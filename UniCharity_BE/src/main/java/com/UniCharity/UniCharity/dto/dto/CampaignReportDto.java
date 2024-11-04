package com.UniCharity.UniCharity.dto.dto;

import java.time.LocalDate;

public class CampaignReportDto {
    Integer id;
    Long totalDonations;
    Long totalRecipients;
    String resultsSummary;
    String lessonsLearned;
    LocalDate reportDate;
    LocalDate createdAt;
    LocalDate updatedAt;
}
