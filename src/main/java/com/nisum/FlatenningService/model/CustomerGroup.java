package com.nisum.FlatenningService.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false , level = AccessLevel.PRIVATE)
public class CustomerGroup {

    List<String> customerGroups;

}
