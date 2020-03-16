package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class StaticOfferRequest {

    String offerId;
    String offerType;
    String offerName;
    Integer offerLimit;

}
