package com.nisum.FlatenningService.service;

import com.nisum.FlatenningService.converter.OfferConverter;
import com.nisum.FlatenningService.dao.OfferDao;
import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.model.StaticOfferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private Logger logger = LoggerFactory.getLogger(OfferService.class);

    @Autowired
    private OfferDao offerDao;

    @Autowired
    private OfferConverter offerConverter;

    public List<OfferResponse> getCombinations(OfferRequest offerRequest) {
        StaticOfferRequest staticOfferRequest = new StaticOfferRequest();
        staticOfferRequest.setOfferId(offerRequest.getOfferId());
        staticOfferRequest.setOfferLimit(offerRequest.getOfferLimit());
        staticOfferRequest.setOfferName(offerRequest.getOfferName());
        staticOfferRequest.setOfferType(offerRequest.getOfferType());

        return offerDao.getCombinations(offerConverter.apply(offerRequest), staticOfferRequest);
    }


}
