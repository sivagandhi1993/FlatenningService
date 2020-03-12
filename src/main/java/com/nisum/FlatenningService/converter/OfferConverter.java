package com.nisum.FlatenningService.converter;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferRequestModified;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OfferConverter implements Function<OfferRequest, OfferRequestModified> {

    @Override
    public OfferRequestModified apply(OfferRequest offerRequest) {

        OfferRequestModified offerRequestModified = new OfferRequestModified();
        AtomicReference<List<String>> atomicReference = new AtomicReference<>();
        offerRequest.getConditions().stream().forEach(t -> {
            Map<String,List<String>> map = new HashMap<>();
            map.put("UPC",t.getProductGroups());
            map.put("CUSTOMER",t.getCustomerGroups());
            offerRequestModified.setConditionsMap(map);
            List<String> flattenedConditions = t.getCustomerGroups().stream().collect(Collectors.toList());
            flattenedConditions.addAll(t.getProductGroups());
            atomicReference.set(flattenedConditions);
        });
        offerRequestModified.setConditions(atomicReference.get());
        offerRequestModified.setStores(offerRequest.getStores());
        offerRequestModified.setTerminals(offerRequest.getTerminals());
        return offerRequestModified;
    }
}
