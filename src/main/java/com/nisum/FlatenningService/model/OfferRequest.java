package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequest {

    String offerId;
    String offerType;
    String offerName;
    Integer offerLimit;
    //Reward need to be added.
    List<Condition> conditions;
    List<String> stores;
    List<String> terminals;
}
