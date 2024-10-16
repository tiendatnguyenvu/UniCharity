package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ViolationActionCreateRequest {
    Integer violation;
    String actionDescription;
    LocalDate actionDate;
    String status;
    LocalDate createdAt = LocalDate.now();
}
