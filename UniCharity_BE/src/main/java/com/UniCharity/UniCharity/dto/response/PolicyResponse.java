package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.models.CampaignReport;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyResponse {
    Integer id;
    Campaign campaign;
    String policyDescription;
    String eligibilityCriteria;
    String approvalRequired;
    LocalDate createdAt;
    LocalDate updatedAt;
}
