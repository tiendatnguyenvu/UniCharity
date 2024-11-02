package com.UniCharity.UniCharity.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class CampaignReportResponse {
    Integer id;
    Long totalDonations;
    Long totalRecipients;
    String resultsSummary;
    String lessonsLearned;
    LocalDate reportDate;
    LocalDate createdAt;
    LocalDate updatedAt;

    int campaign;

    List<FundAllocationResponse> fundAllocations;
}
