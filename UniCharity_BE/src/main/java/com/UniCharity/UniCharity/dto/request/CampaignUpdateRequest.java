package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignUpdateRequest {
    String title;
    String description;
    long targetAmount = 0;
    long currentAmount = 0;
    LocalDate startDate;
    LocalDate endDate;
    String status;
}
