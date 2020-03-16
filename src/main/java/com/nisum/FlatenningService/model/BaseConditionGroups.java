package com.nisum.FlatenningService.model;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class BaseConditionGroups {
    List<String> customerGroups = Lists.newArrayList();
    List<String> productGroups = Lists.newArrayList();
}
