package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.entities.Donation;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionResponse {
    Integer id;
    DonationResponse donation;
    String transactionCode;
    String paymentGateway;
    LocalDateTime transactionDate;
    String transactionStatus;
    Long amount;
    String responseCode;
    String transactionDescription;
}
