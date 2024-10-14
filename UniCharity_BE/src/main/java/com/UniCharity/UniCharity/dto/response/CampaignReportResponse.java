package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.Campaign;
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
    Integer campaign;
    Long totalDonations;
    Long totalRecipients;
    String resultsSummary;
    String lessonsLearned;
    LocalDate reportDate;
    LocalDate createdAt;
    LocalDate updatedAt;
}
