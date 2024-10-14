package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignReportUpdateRequest {
    Long totalDonations;
    Long totalRecipients;
    String resultsSummary;
    String lessonsLearned;
    LocalDate reportDate;
    LocalDate updatedAt;
}
