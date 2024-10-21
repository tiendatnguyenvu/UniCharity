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
public class CampaignReportCreateRequest {
    @Positive(message = "ID chiến dịch phải là số dương")
    int campaign;

    @NotNull(message = "Tổng số tiền quyên góp không được để trống")
    @PositiveOrZero(message = "Tổng số tiền quyên góp phải là số không âm")
    Long totalDonations;

    @NotNull(message = "Tổng số người nhận không được để trống")
    @PositiveOrZero(message = "Tổng số người nhận phải là số không âm")
    Long totalRecipients;

    @NotBlank(message = "Tóm tắt kết quả không được để trống")
    @Size(max = 1000, message = "Tóm tắt kết quả không được vượt quá 1000 ký tự")
    String resultsSummary;

    @NotBlank(message = "Bài học rút ra không được để trống")
    @Size(max = 1000, message = "Bài học rút ra không được vượt quá 1000 ký tự")
    String lessonsLearned;

    @PastOrPresent(message = "Ngày tạo phải là ngày hiện tại hoặc trong quá khứ")
    LocalDate createdAt = LocalDate.now();
    LocalDate reportDate;
    LocalDate updatedAt;
}
