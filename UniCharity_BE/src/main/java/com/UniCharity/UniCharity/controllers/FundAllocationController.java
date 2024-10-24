package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.FundAllocationCreateRequest;
import com.UniCharity.UniCharity.dto.request.FundAllocationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.FundAllocationResponse;
import com.UniCharity.UniCharity.services.iservices.IFundAllocationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fund_allocations")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FundAllocationController {
    IFundAllocationService fundAllocationService;

    @PostMapping("/create")
    ApiResponse<FundAllocationResponse> createFundAllocation(@RequestBody @Valid FundAllocationCreateRequest request) {
        return ApiResponse.<FundAllocationResponse>builder().result(fundAllocationService.createFundAllocation(request)).build();
    }

    @GetMapping
    ApiResponse<List<FundAllocationResponse>> getFundAllocations() {
        return ApiResponse.<List<FundAllocationResponse>>builder().result(fundAllocationService.getFundAllocations()).build();
    }

    @GetMapping("/get-by-id/{fundAllocationId}")
    ApiResponse<FundAllocationResponse> getFundAllocation(@PathVariable("fundAllocationId") int fundAllocationId) {
        return ApiResponse.<FundAllocationResponse>builder().result(fundAllocationService.getFundAllocation(fundAllocationId)).build();
    }

    @PutMapping("/update/{fundAllocationId}")
    ApiResponse<FundAllocationResponse> updateFundAllocation(@PathVariable("fundAllocationId") int fundAllocationId, @RequestBody @Valid FundAllocationUpdateRequest request) {
        return ApiResponse.<FundAllocationResponse>builder().result(fundAllocationService.updateFundAllocation(fundAllocationId, request)).build();
    }
}
