package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FacultyRequestResponse {
    Integer id;
    int faculty;
    int department;
    String title;
    String description;
    Long requestedAmount;
    LocalDate requestDate;
    String status;
}
