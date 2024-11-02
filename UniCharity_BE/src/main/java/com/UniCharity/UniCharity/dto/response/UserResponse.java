package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.entities.Donation;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Integer id;
    String name;
    String email;
    String phone;
    String password;
    String role;

    List<FundAllocationResponse> fundAllocations;
    List<CampaignResponse> campaigns;
    List<Donation> donations;
}
