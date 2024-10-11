package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.models.User;
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
public class CampaignResponse {
    Integer id;
    String title;
    String description;
    long targetAmount;
    long currentAmount;
    LocalDate startDate;
    LocalDate endDate;
    Integer department;
    Integer createdBy;
    String status;
    String image;
}
