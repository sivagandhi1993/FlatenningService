package com.nisum.FlatenningService.controller;

import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/offerResponseFlat")
    public List<OfferResponse> getOfferResponse(@RequestBody OfferRequest offerRequest){

        return offerService.getCombinations(offerRequest);
    }
}
