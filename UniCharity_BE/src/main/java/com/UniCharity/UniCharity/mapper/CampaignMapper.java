package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.entities.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CampaignMapper {

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "policyCreateRequests", ignore = true)
    Campaign toCampaign(CampaignCreateRequest request);

    @Mapping(source = "createdBy", target = "createdBy")
    CampaignResponse toCampaignResponse(Campaign campaign);

    void updateCampaign(@MappingTarget Campaign campaign, CampaignUpdateRequest request);
}
