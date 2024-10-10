package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignResponse {
    String title;
    String description;
    BigDecimal targetAmount;
    BigDecimal currentAmount;
    Instant startDate;
    Instant endDate;
    Department department;
    User createdBy;
    String status;
}
