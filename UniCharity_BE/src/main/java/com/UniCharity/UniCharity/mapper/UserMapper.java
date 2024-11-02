package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.UserCreateRequest;
import com.UniCharity.UniCharity.dto.request.UserUpdateRequest;
import com.UniCharity.UniCharity.dto.response.UserResponse;
import com.UniCharity.UniCharity.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {FundAllocationMapper.class, CampaignMapper.class, DonationMapper.class})
public interface UserMapper {
    User toUser(UserCreateRequest request);

    @Mapping(source = "fundAllocations", target = "fundAllocations")
    @Mapping(source = "campaigns", target = "campaigns")
    @Mapping(source = "donations", target = "donations")
    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
