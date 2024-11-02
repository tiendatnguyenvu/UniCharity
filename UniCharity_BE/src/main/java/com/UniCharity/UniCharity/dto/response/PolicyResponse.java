package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyResponse {
    Integer id;
    String policyDescription;
    String eligibilityCriteria;
    String approvalRequired;
    LocalDate createdAt;
    LocalDate updatedAt;

    int campaign;

    List<PolicyViolationResponse> policyViolations;
}
