package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.models.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    Campaign toCampaign(CampaignCreateRequest request);

    @Mapping(source = "createdBy.id", target = "createdBy")
    @Mapping(source = "department.id", target = "department")
    CampaignResponse toCampaignResponse(Campaign campaign);

    void updateCampaign(@MappingTarget Campaign campaign, CampaignUpdateRequest request);
}
