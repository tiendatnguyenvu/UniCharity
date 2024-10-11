package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
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
    long currentAmount;
    LocalDate startDate;
    LocalDate endDate;
    int departmentId;
    int createdBy;
    String status;
    String image;
}
