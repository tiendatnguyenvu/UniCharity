package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse implements Serializable {
    int paymentStatus;
    String orderInfo;
    String paymentTime;
    String cardType;
    String transactionId;
    String transactionStatus;
    String totalPrice;
}
