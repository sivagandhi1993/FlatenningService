package com.nisum.FlatenningService.model;

import com.google.common.collect.ListMultimap;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OfferRequestModified {

    Set<String> conditions;
    Set<String> stores;
    Set<String> terminals;
    Map<String,Set<String>> conditionsMap;

}
