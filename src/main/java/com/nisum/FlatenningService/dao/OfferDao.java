package com.nisum.FlatenningService.dao;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nisum.FlatenningService.model.Condition;
import com.nisum.FlatenningService.model.OfferRequestModified;
import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.model.StaticOfferRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OfferDao {

    public List<OfferResponse> getCombinations(OfferRequestModified offerRequestModified, StaticOfferRequest staticOfferRequest) {


        Set<List<Object>> offerResponseObject = generateCombinations(Sets.newHashSet(offerRequestModified.getConditions())
                , Sets.newHashSet(offerRequestModified.getStores())
                , Sets.newHashSet(offerRequestModified.getTerminals()));
        List<OfferResponse> offerResponses = Lists.newArrayList();

        offerResponseObject.forEach(t -> {
            OfferResponse offerResponse = new OfferResponse();
            offerResponse.setOfferId(staticOfferRequest.getOfferId());
            offerResponse.setOfferName(staticOfferRequest.getOfferName());
            offerResponse.setOfferType(staticOfferRequest.getOfferType());
            offerResponse.setPreCondition(t.get(0).toString());
            offerResponse.setStoreId(t.get(1).toString());
            offerResponse.setTerminal(t.get(2).toString());
            offerResponse.setId(t.get(0).toString());
            offerRequestModified.getConditionsMap().entrySet().stream().filter(s -> s.getValue().contains(t.get(0).toString())).forEach(g -> {
                offerResponse.setIdType(g.getKey());
            });
            offerResponses.add(offerResponse);
        });
        return offerResponses;
    }

    private Set<List<Object>> generateCombinations(HashSet<String> conditions, HashSet<String> stores, HashSet<String> terminals) {
        return Sets.cartesianProduct(conditions, stores, terminals);
    }


}
