package com.nisum.FlatenningService.model;

import com.google.common.collect.ListMultimap;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequestModified {

    List<String> conditions;
    List<String> stores;
    List<String> terminals;
    Map<String,List<String>> conditionsMap;

}
