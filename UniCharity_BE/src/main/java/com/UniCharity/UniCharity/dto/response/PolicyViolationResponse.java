package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.entities.Policy;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyViolationResponse {
    Integer id;
    String violationDescription;
    LocalDate violationDate;
    String status;
    LocalDate createdAt;
    LocalDate updatedAt;

    int policy;

    List<ViolationActionResponse> violationActions;
}
