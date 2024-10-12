package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScholarshipResponse {
    Integer id;
    String name;
    String description;
    Long targetAmount;
    int department;
    Integer availableSlots;
    Integer awardedSlots;
    String status;
}
