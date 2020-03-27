package com.nisum.FlatenningService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.nisum.FlatenningService.dao.OfferDao;
import com.nisum.FlatenningService.model.*;
import org.assertj.core.util.Lists;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;
import static com.nisum.FlatenningService.util.CONSTANTS.ANDCUST;
import static com.nisum.FlatenningService.util.CONSTANTS.ANDUPC;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OfferDao.class})
public class OfferDaoTest {

    @Autowired
    private OfferDao offerDao;

    @Test
    public void Test_getOfferResponse() {
        OfferRequest offerRequest = generateOfferRequest();
        OfferRequestModified offerRequestModified = generateOfferModifiedRequest(offerRequest);
        /*Mockito.when(offerConverter.apply(offerRequest)).thenReturn(generateOfferModifiedRequest(offerRequest));
        //        Mockito.when(offerDao.getCombinations(generateOfferModifiedRequest(offerRequest),staticOfferRequest()));*/
        //        //data combination testing
        List<OfferResponse> offerResponses = offerDao.getCombinations(offerRequestModified, staticOfferRequest());
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
        List<String> terminals = Lists.newArrayList("1", "2", "3");
        offerRequestModified.setTerminals(terminals);
        List<String> stores = Lists.newArrayList("0001", "0002");
        offerRequestModified.setStores(stores);
        List<String> conditions = Lists.newArrayList("ANY", "GO", "1234", "3214");
        offerRequestModified.setConditions(conditions);
        Map<String, List<String>> map = Maps.newHashMap();
        map.put(ANDUPC, Lists.newArrayList("1234", "3214"));
        map.put(ANDCUST, Lists.newArrayList("ANY", "GO"));
        offerRequestModified.setConditionsMap(map);
        return offerRequestModified;
    }

    @NotNull
    private OfferRequest generateOfferRequest() {
        OfferRequest offerRequest = new OfferRequest();
        offerRequest.setOfferId("1234567");
        offerRequest.setOfferLimit(1);
        offerRequest.setOfferName("Buy these items an get item at 20 % off");
        offerRequest.setOfferType("1");
        List<Condition> conditions = Lists.newArrayList();
        Condition condition = new Condition();
        AND and = new AND();
        List<String> customerGroups = Lists.newArrayList();
        customerGroups.add("ANY");
        customerGroups.add("GO");
        List<String> productGroups = Lists.newArrayList();
        productGroups.add("1234");
        productGroups.add("3214");
        and.setCustomerGroups(customerGroups);
        and.setProductGroups(productGroups);
        condition.setAnd(and);
        conditions.add(condition);
        offerRequest.setConditions(conditions);
        List<String> terminals = Lists.newArrayList("1", "2", "3");
        offerRequest.setTerminals(terminals);
        List<String> stores = Lists.newArrayList("0001", "0002");
        offerRequest.setStores(stores);
        return offerRequest;
    }

}
