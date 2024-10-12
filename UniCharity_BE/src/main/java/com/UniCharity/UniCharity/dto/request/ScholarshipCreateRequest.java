package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScholarshipCreateRequest {
    String name;
    String description;
    Long targetAmount;
    int department;
    Integer availableSlots;
    Integer awardedSlots;
    String status;
}
