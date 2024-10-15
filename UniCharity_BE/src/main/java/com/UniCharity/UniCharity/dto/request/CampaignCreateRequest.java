package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignCreateRequest {
    String title;
    String description;
    long targetAmount;
    long currentAmount = 0;
    LocalDate createdAt = LocalDate.now();
    LocalDate startDate;
    LocalDate endDate;
    int createdBy;
    String status;
}
