package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.FundAllocationCreateRequest;
import com.UniCharity.UniCharity.dto.request.FundAllocationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.fundAllocation.FundAllocationResponse;

import java.util.List;

public interface IFundAllocationService {
    public FundAllocationResponse createFundAllocation(FundAllocationCreateRequest request);
    public List<FundAllocationResponse> getFundAllocations();
    public FundAllocationResponse getFundAllocation(int fundAllocationId);
    public FundAllocationResponse updateFundAllocation(int fundAllocationId, FundAllocationUpdateRequest request);
}
