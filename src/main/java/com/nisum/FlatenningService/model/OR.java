package com.nisum.FlatenningService.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class OR extends BaseConditionGroups {

}
