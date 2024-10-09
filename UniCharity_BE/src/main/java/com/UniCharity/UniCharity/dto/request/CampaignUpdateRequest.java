package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignUpdateRequest {
    String title;
    String description;
    BigDecimal targetAmount;
    BigDecimal currentAmount;
    Instant startDate;
    Instant endDate;
    String status;
}
