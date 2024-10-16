package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.FundAllocationCreateRequest;
import com.UniCharity.UniCharity.dto.request.FundAllocationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.FundAllocationResponse;
import com.UniCharity.UniCharity.models.FundAllocation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FundAllocationMapper {
    @Mapping(target = "report", ignore = true)
    @Mapping(target = "user", ignore = true)
    FundAllocation toFundAllocation(FundAllocationCreateRequest request);

    FundAllocationResponse toFundAllocationResponse(FundAllocation fundAllocation);

    void updateFundAllocation(@MappingTarget FundAllocation fundAllocation, FundAllocationUpdateRequest request);
}
