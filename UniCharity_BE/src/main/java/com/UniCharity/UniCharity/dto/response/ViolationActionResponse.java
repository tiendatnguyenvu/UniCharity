package com.UniCharity.UniCharity.dto.response;

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
    PolicyViolationResponse violation;
    String actionDescription;
    LocalDate actionDate;
    String status;
    LocalDate createdAt;
}
