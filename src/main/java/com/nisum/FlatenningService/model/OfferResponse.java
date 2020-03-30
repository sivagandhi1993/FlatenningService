package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
//Why there is no annotation here like entity..
public class OfferResponse {
    //    What is the use of QuerySqlField here..
//    We need to look into association..
    @QuerySqlField(notNull = true)
    @NotNull
    String offerId;
    @QuerySqlField
    String offerType;
    @QuerySqlField
    String storeId;
    @QuerySqlField
    String terminal;
    @QuerySqlField
    String preCondition;
    @QuerySqlField
    String id;
    @QuerySqlField
    String idType;

}
