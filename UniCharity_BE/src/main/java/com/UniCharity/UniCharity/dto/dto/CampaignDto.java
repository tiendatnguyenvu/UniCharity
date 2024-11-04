package com.UniCharity.UniCharity.dto.dto;

import java.time.LocalDate;

public class CampaignDto {
    Integer id;
    String title;
    String description;
    long targetAmount;
    long currentAmount;
    LocalDate createdAt;
    LocalDate startDate;
    LocalDate endDate;
    String status;
}
