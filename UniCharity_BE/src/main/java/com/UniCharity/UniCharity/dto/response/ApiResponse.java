package com.UniCharity.UniCharity.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // cac gia tri null khong duoc tra ve
public class ApiResponse<T> {
    @Builder.Default
    int code = 1000;
    String message;
    T result;
}
