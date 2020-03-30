package com.nisum.FlatenningService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.nisum.FlatenningService.model.*;
import com.nisum.FlatenningService.service.OfferServiceMain;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.nisum.FlatenningService.util.CONSTANTS.ANDCUST;
import static com.nisum.FlatenningService.util.CONSTANTS.ANDUPC;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OfferServiceMain.class})
public class OfferServiceMainTest {

    @Autowired
    private OfferServiceMain offerServiceMain;

    @Test
    public void Test_getOfferResponse() {
        OfferRequest offerRequest = generateOfferRequest();
        OfferRequestModified offerRequestModified = generateOfferModifiedRequest(offerRequest);
        /*Mockito.when(offerConverter.apply(offerRequest)).thenReturn(generateOfferModifiedRequest(offerRequest));
        //        Mockito.when(offerDao.getCombinations(generateOfferModifiedRequest(offerRequest),staticOfferRequest()));*/
        //        //data combination testing
        List<OfferResponse> offerResponses = offerServiceMain.getCombinations(offerRequestModified, staticOfferRequest());
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        try {
            String jsonString = mapper.writeValueAsString(offerResponses);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(24, offerResponses.size());
    }

    private StaticOfferRequest staticOfferRequest() {
        StaticOfferRequest offerRequest = new StaticOfferRequest();
        offerRequest.setOfferId("1234567");
        offerRequest.setOfferLimit(1);
        offerRequest.setOfferName("Buy these items an get item at 20 % off");
        offerRequest.setOfferType("1");
        return offerRequest;
    }

    private OfferRequestModified generateOfferModifiedRequest(OfferRequest offerRequest) {
        OfferRequestModified offerRequestModified = new OfferRequestModified();
        Set<String> terminals = Sets.newHashSet("1", "2", "3");
        offerRequestModified.setTerminals(terminals);
        Set<String> stores = Sets.newHashSet("0001", "0002");
        offerRequestModified.setStores(stores);
        Set<String> conditions = Sets.newHashSet("ANY", "GO", "1234", "3214");
        offerRequestModified.setConditions(conditions);
        Map<String, Set<String>> map = Maps.newHashMap();
        map.put(ANDUPC, Sets.newHashSet("1234", "3214"));
        map.put(ANDCUST, Sets.newHashSet("ANY", "GO"));
        offerRequestModified.setConditionsMap(map);
        return offerRequestModified;
    }

    @NotNull
    private OfferRequest generateOfferRequest() {
        OfferRequest offerRequest = new OfferRequest();
        offerRequest.setOfferId("1234567");
        offerRequest.setOfferLimit(1);
        //offerRequest.setOfferName("Buy these items an get item at 20 % off");
        offerRequest.setOfferType("1");
        Set<Condition> conditions = Sets.newHashSet();
        Condition condition = new Condition();
        AND and = new AND();
        Set<String> customerGroups = Sets.newHashSet();
        customerGroups.add("ANY");
        customerGroups.add("GO");
        Set<String> productGroups = Sets.newHashSet();
        productGroups.add("1234");
        productGroups.add("3214");
        and.setCustomerGroups(customerGroups);
        and.setProductGroups(productGroups);
        condition.setAnd(and);
        conditions.add(condition);
        offerRequest.setConditions(conditions);
        Set<String> terminals =Sets.newHashSet("1", "2", "3");
        offerRequest.setTerminals(terminals);
        Set<String> stores = Sets.newHashSet("0001", "0002");
        offerRequest.setStores(stores);
        return offerRequest;
    }

}
