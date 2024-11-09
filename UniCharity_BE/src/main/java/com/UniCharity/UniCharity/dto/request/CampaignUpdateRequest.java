package com.UniCharity.UniCharity.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignUpdateRequest {
    @NotBlank(message = "CAMPAIGN_TITLE_IS_REQUIRED")
    String title;

    @NotBlank(message = "DESCRIPTION_IS_REQUIRED")
    String description;

    @Positive(message = "TARGET_AMOUNT_MUST_BE_POSITIVE")
    long targetAmount = 0;

    long currentAmount = 0;

    LocalDate createAt;

    LocalDate startDate;

    LocalDate endDate;

    int createBy;

    @NotBlank(message = "STATUS_CANNOT_BE_BLANK")
    @Pattern(regexp = "Active|Pending|Completed|Cancelled", message = "INVALID_STATUS_VALUE")
    String status;

    List<PolicyCreateRequest> policies;
}
