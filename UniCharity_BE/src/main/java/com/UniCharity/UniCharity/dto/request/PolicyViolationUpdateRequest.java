package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyViolationUpdateRequest {
    String violationDescription;
    LocalDate violationDate;
    String status;
    LocalDate updatedAt = LocalDate.now();
}
