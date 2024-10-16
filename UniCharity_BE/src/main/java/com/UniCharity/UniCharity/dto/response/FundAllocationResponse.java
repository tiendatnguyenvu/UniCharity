package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.CampaignReport;
import com.UniCharity.UniCharity.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FundAllocationResponse {
    Integer id;
    CampaignReport report;
    String category;
    Long amount;
    String description;
    LocalDate createdAt;
    User user;
}
