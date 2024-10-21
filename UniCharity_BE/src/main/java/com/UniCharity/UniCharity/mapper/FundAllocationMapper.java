package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.FundAllocationCreateRequest;
import com.UniCharity.UniCharity.dto.request.FundAllocationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.FundAllocationResponse;
import com.UniCharity.UniCharity.entities.FundAllocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CampaignReportMapper.class, UserMapper.class})
public interface FundAllocationMapper {
    @Mapping(target = "report", ignore = true)
    @Mapping(target = "user", ignore = true)
    FundAllocation toFundAllocation(FundAllocationCreateRequest request);

    @Mapping(source = "report", target = "report")
    @Mapping(source = "user", target = "user")
    FundAllocationResponse toFundAllocationResponse(FundAllocation fundAllocation);

    void updateFundAllocation(@MappingTarget FundAllocation fundAllocation, FundAllocationUpdateRequest request);
}
