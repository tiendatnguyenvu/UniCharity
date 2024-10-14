package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.CampaignReportCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignReportUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignReportResponse;
import com.UniCharity.UniCharity.models.CampaignReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CampaignReportMapper {
    @Mapping(target = "campaign", ignore = true)
    CampaignReport toCamportReport(CampaignReportCreateRequest request);

    @Mapping(source = "campaign.id", target = "campaign")
    CampaignReportResponse toCamportRequestResponse(CampaignReport campaignReport);

    void updateCampaignReport(@MappingTarget CampaignReport campaignReport, CampaignReportUpdateRequest request);
}
