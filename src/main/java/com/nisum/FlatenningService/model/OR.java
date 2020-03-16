package com.nisum.FlatenningService.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class OR extends BaseConditionGroups {

}
