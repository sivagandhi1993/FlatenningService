package com.nisum.FlatenningService.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequest {

    String offerId;
    String offerType;
    String offerName;
    Integer offerLimit;
    //Reward need to be added.
    List<String> conditions;
    List<String> stores;
    List<String> terminals;
}
