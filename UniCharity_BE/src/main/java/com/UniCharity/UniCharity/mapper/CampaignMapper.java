package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.CampaignReport;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ImageMapper.class, PolicyMapper.class, DonationMapper.class, CampaignReportMapper.class})
public interface CampaignMapper {
    @Mapping(target = "createdBy", ignore = true)
    Campaign toCampaign(CampaignCreateRequest request);

    @Mapping(source = "createdBy.id", target = "createdBy")
    @Mapping(source = "images", target = "images")
    @Mapping(source = "policies", target = "policies")
    @Mapping(source = "donations", target = "donations")
    @Mapping(source = "campaignReports", target = "campaignReports")
    CampaignResponse toCampaignResponse(Campaign campaign);

    void updateCampaign(@MappingTarget Campaign campaign, CampaignUpdateRequest request);
}
