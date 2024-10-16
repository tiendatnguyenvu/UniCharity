package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyViolationCreateRequest {
    Integer policy;
    String violationDescription;
    LocalDate violationDate;
    String status;
    LocalDate createdAt = LocalDate.now();
    LocalDate updatedAt = LocalDate.now();
}
