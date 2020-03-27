package com.nisum.FlatenningService.model;

import com.google.common.collect.Lists;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class BaseConditionGroups {
    Set<String> customerGroups = Sets.newHashSet();
    Set<String> productGroups = Sets.newHashSet();
}
