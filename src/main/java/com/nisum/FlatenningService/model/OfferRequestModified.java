package com.nisum.FlatenningService.model;

import com.google.common.collect.ListMultimap;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequestModified {

    List<String> conditions;
    List<String> stores;
    List<String> terminals;
    Map<String,List<String>> conditionsMap;

}
