package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FundAllocationResponse {
    Integer id;
    Integer report;
    String category;
    Long amount;
    String description;
    LocalDate createdAt;
    Integer user;
}
