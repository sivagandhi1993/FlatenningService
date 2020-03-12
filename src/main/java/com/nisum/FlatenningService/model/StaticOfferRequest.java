package com.nisum.FlatenningService.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class StaticOfferRequest {

    String offerId;
    String offerType;
    String offerName;
    Integer offerLimit;

}
