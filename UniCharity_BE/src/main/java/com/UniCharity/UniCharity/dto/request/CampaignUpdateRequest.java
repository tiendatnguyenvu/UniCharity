package com.UniCharity.UniCharity.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CampaignUpdateRequest {
    @NotBlank(message = "CAMPAIGN_TITLE_IS_REQUIRED")
    @Size(max = 100, message = "CAMPAIGN_TITLE_TOO_LONG")
    String title;

    @NotBlank(message = "DESCRIPTION_IS_REQUIRED")
    String description;

    @Positive(message = "TARGET_AMOUNT_MUST_BE_POSITIVE")
    long targetAmount = 0;

    @Min(value = 0, message = "CURRENT_AMOUNT_MUST_BE_NON_NEGATIVE")
    long currentAmount = 0;

    @FutureOrPresent(message = "START_DATE_MUST_BE_FUTURE_OR_PRESENT")
    LocalDate startDate;

    @Future(message = "END_DATE_MUST_BE_IN_FUTURE")
    LocalDate endDate;

    @NotBlank(message = "STATUS_CANNOT_BE_BLANK")
    @Pattern(regexp = "active|inactive|completed|cancelled", message = "INVALID_STATUS_VALUE")
    String status;
}
