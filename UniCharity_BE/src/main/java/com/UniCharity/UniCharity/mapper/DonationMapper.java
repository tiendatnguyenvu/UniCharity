package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.dto.response.DonationResponse;
import com.UniCharity.UniCharity.entities.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CampaignMapper.class})
public interface DonationMapper {
    @Mapping(target = "campaign", ignore = true)
    @Mapping(target = "user", ignore = true)
    Donation toDonation(DonationCreateRequest request);

    @Mapping(source = "campaign", target = "campaign")
    @Mapping(source = "user", target = "user")
    DonationResponse toDonationResponse(Donation donation);
}
