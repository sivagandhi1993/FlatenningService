package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequest {

    String offerId;
    String offerType;
    Integer offerLimit;
    //Reward need to be added.
    Set<Condition> conditions;
    Set<String> stores;
    Set<String> terminals;
}
