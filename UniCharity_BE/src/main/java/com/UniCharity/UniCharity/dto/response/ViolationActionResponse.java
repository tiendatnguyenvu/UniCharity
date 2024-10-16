package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.PolicyViolation;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViolationActionResponse {
    Integer id;
    PolicyViolation violation;
    String actionDescription;
    LocalDate actionDate;
    String status;
    LocalDate createdAt;
}
