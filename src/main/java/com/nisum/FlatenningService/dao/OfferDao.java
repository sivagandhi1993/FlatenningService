package com.nisum.FlatenningService.dao;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nisum.FlatenningService.model.OfferRequestModified;
import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.model.StaticOfferRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

import static com.nisum.FlatenningService.util.CONSTANTS.*;

@Component
public class OfferDao {

    public List<OfferResponse> getCombinations(OfferRequestModified offerRequestModified, StaticOfferRequest staticOfferRequest) {

        Set<List<Object>> offerResponseObject = generateCombinations(offerRequestModified.getConditions()
                , offerRequestModified.getStores()
                , offerRequestModified.getTerminals());
        List<OfferResponse> offerResponses = Lists.newArrayList();

        offerResponseObject.forEach(t -> {
            OfferResponse offerResponse = new OfferResponse();
            offerResponse.setOfferId(staticOfferRequest.getOfferId());
            //offerResponse.setOfferName(staticOfferRequest.getOfferName());
            offerResponse.setOfferType(staticOfferRequest.getOfferType());
            if (Objects.nonNull(t.get(0))) {
                offerResponse.setId(t.get(0).toString());
                Optional<String> key = getKey(offerRequestModified.getConditionsMap(), t.get(0).toString()).findFirst();
                if (key.isPresent()) {
                    setPreConditionAndType(key.get(), offerResponse);
                }
            }
            if (Objects.nonNull(t.get(1))) {
                offerResponse.setStoreId(t.get(1).toString());
            }
            if (Objects.nonNull(t.get(2))) {
                offerResponse.setTerminal(t.get(2).toString());
            }
            offerResponses.add(offerResponse);
        });
        return offerResponses;
    }

    public <K, V> Stream<K> getKey(Map<K, Set<V>> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(value))
                .map(Map.Entry::getKey);
    }

    private void setPreConditionAndType(String key, OfferResponse offerResponse) {
        switch (key) {
            case ANDCUST:
                offerResponse.setPreCondition(AND);
                offerResponse.setIdType(CUSTOMER);
            case ANDUPC:
                offerResponse.setPreCondition(AND);
                offerResponse.setIdType(UPC);
            case ORCUST:
                offerResponse.setPreCondition(OR);
                offerResponse.setIdType(CUSTOMER);
            case ORUPC:
                offerResponse.setPreCondition(OR);
                offerResponse.setIdType(UPC);
            case NOTCUST:
                offerResponse.setPreCondition(NOT);
                offerResponse.setIdType(CUSTOMER);
            case NOTUPC:
                offerResponse.setPreCondition(NOT);
                offerResponse.setIdType(UPC);
        }
    }

    private Set<List<Object>> generateCombinations(Set<String> conditions, Set<String> stores, Set<String> terminals) {
        return Sets.cartesianProduct(conditions, stores, terminals);
    }


}
