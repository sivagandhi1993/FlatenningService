package com.nisum.FlatenningService.converter;

import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferRequestModified;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class OfferConverter implements Function<OfferRequest, OfferRequestModified> {

    @Override
    public OfferRequestModified apply(OfferRequest offerRequest) {

        OfferRequestModified offerRequestModified = new OfferRequestModified();
        offerRequestModified.setConditions(offerRequest.getConditions());
        offerRequestModified.setStores(offerRequest.getStores());
        offerRequestModified.setTerminals(offerRequest.getTerminals());
        return offerRequestModified;
    }
}
