package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationResponse {
    Integer id;
    CampaignResponse campaign;
    Long amount;
    String paymentMethod;
    LocalDateTime donationDate;
}
