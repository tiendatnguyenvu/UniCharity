package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.entities.Policy;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignResponse {
    Integer id;
    String title;
    String description;
    long targetAmount;
    long currentAmount;
    LocalDate createdAt;
    LocalDate startDate;
    LocalDate endDate;
    String status;

    int createdBy;

    List<ImageResponse> images;
    List<PolicyResponse> policies;
    List<DonationResponse> donations;
    List<CampaignReportResponse> campaignReports;
}
