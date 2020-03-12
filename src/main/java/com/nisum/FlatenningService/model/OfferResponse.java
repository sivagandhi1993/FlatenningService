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
