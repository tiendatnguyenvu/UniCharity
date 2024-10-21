package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyViolationResponse {
    Integer id;
    PolicyResponse policy;
    String violationDescription;
    LocalDate violationDate;
    String status;
    LocalDate createdAt;
    LocalDate updatedAt;
}
