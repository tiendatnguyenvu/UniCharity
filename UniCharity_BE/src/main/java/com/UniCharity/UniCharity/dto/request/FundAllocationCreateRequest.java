package com.UniCharity.UniCharity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FundAllocationCreateRequest {
    int report;
    String category;
    Long amount;
    String description;
    LocalDate createdAt = LocalDate.now();
    int user;
}
