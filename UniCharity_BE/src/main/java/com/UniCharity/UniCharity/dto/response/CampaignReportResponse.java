package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignReportResponse {
    Integer id;
    CampaignResponse campaign;
    Long totalDonations;
    Long totalRecipients;
    String resultsSummary;
    String lessonsLearned;
    LocalDate reportDate;
    LocalDate createdAt;
    LocalDate updatedAt;
}
