package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.dto.response.DonationResponse;
import com.UniCharity.UniCharity.entities.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TransactionMapper.class})
public interface DonationMapper {
    @Mapping(target = "campaign", ignore = true)
    @Mapping(target = "user", ignore = true)
    Donation toDonation(DonationCreateRequest request);

    @Mapping(source = "campaign.id", target = "campaign")
    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "transactions", target = "transactions")
    DonationResponse toDonationResponse(Donation donation);
}
