package com.nisum.FlatenningService.converter;

import com.google.common.collect.Lists;
import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferRequestModified;
import org.assertj.core.util.Sets;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import static com.nisum.FlatenningService.util.CONSTANTS.*;

@Component
public class OfferConverter implements Function<OfferRequest, OfferRequestModified> {

    @Override
    public OfferRequestModified apply(OfferRequest offerRequest) {

        OfferRequestModified offerRequestModified = new OfferRequestModified();
        AtomicReference<Set<String>> atomicReference = new AtomicReference<>();
        offerRequest.getConditions().forEach(t -> {
            Map<String, Set<String>> map = new HashMap<>();

            if (Objects.nonNull(t.getAnd()) && Objects.nonNull(t.getAnd().getProductGroups())) {
                map.put(ANDUPC, t.getAnd().getProductGroups());
            }

            if (Objects.nonNull(t.getOr()) && Objects.nonNull(t.getOr().getProductGroups())) {
                map.put(ORUPC, t.getOr().getProductGroups());
            }

            if (Objects.nonNull(t.getNot()) && Objects.nonNull(t.getNot().getProductGroups())) {
                map.put(NOTUPC, t.getNot().getProductGroups());
            }

            if (Objects.nonNull(t.getAnd()) && Objects.nonNull(t.getAnd().getCustomerGroups())) {
                map.put(ANDCUST, t.getAnd().getCustomerGroups());
            }

            if (Objects.nonNull(t.getOr()) && Objects.nonNull(t.getOr().getCustomerGroups())) {
                map.put(ORCUST, t.getOr().getCustomerGroups());
            }

            if (Objects.nonNull(t.getNot()) && Objects.nonNull(t.getNot().getCustomerGroups())) {
                map.put(NOTCUST, t.getNot().getCustomerGroups());
            }

            offerRequestModified.setConditionsMap(map);

            Set<String> flatenedConditions = Sets.newHashSet();;

            map.entrySet().forEach(g -> {
                flatenedConditions.addAll(g.getValue());
            });

            atomicReference.set(flatenedConditions);
        });
        offerRequestModified.setConditions(atomicReference.get());
        offerRequestModified.setStores(offerRequest.getStores());
        offerRequestModified.setTerminals(offerRequest.getTerminals());
        return offerRequestModified;
    }
}
