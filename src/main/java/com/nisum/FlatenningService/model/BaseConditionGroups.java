package com.nisum.FlatenningService.model;

import com.google.common.collect.Lists;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class BaseConditionGroups {
    List<String> customerGroups = Lists.newArrayList();
    List<String> productGroups = Lists.newArrayList();
}
