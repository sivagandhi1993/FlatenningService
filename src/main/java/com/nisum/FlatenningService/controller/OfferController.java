package com.nisum.FlatenningService.controller;

import com.google.common.collect.Lists;
import com.nisum.FlatenningService.model.OfferRequest;
import com.nisum.FlatenningService.model.OfferResponse;
import com.nisum.FlatenningService.repository.OfferRepository;
import com.nisum.FlatenningService.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.IgniteAtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@RestController
@Slf4j
public class OfferController {

    private Logger logger = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private IgniteAtomicLong igniteAtomicLong;

    @PostMapping("/offerResponseFlat")
    public List<OfferResponse> getOfferResponse(@RequestBody OfferRequest offerRequest) {
        logger.info("To get all the combinations possible from the offer request!!");
        List<OfferResponse> offerResponses = offerService.getCombinations(offerRequest);

        offerResponses.forEach(offerResponse -> {
            Long keyGenerator = igniteAtomicLong.getAndIncrement();
            offerRepository.save(keyGenerator.intValue(), offerResponse);
        });
        return offerResponses;
    }

    @GetMapping("/getAllCombinationsFromIgnite")
public List<OfferResponse> getAllCombinationsFromIgnite() {
    List<OfferResponse> allOfferResponseCombinations = newArrayList();
    offerRepository.findAll().forEach(allOfferResponseCombinations::add);
    return allOfferResponseCombinations;
}
}
