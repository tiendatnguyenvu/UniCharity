package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScholarshipUpdateRequest {
    String name;
    String description;
    Long targetAmount;
    Integer availableSlots;
    Integer awardedSlots;
    String status;
}
