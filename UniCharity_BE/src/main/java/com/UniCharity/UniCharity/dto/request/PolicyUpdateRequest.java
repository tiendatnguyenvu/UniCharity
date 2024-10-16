package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyUpdateRequest {
    String policyDescription;
    String eligibilityCriteria;
    String approvalRequired;
    LocalDate updatedAt = LocalDate.now();
}
