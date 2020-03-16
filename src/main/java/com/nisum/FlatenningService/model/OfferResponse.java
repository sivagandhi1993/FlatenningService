package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferResponse {
    String offerId;
    String offerType;
    String offerName;
    String storeId;
    String terminal;
    String preCondition;
    String id;
    String idType;
}
