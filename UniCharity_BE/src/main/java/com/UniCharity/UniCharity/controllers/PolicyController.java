package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.PolicyResponse;
import com.UniCharity.UniCharity.services.PolicyService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PolicyController {
    PolicyService policyService;

    @PostMapping("/create")
    ApiResponse<PolicyResponse> createPolicy(@RequestBody @Valid PolicyCreateRequest request) {
        return ApiResponse.<PolicyResponse>builder().result(policyService.createPolicy(request)).build();
    }

    @GetMapping
    ApiResponse<List<PolicyResponse>> getPolicies() {
        return ApiResponse.<List<PolicyResponse>>builder().result(policyService.getPolicies()).build();
    }

    @GetMapping("/get-by-id/{policyId}")
    ApiResponse<PolicyResponse> getPolicy(@PathVariable("policyId") int policyId) {
        return ApiResponse.<PolicyResponse>builder().result(policyService.getPolicy(policyId)).build();
    }

    @PutMapping("/update/{policyId}")
    ApiResponse<PolicyResponse> updatePolicy(@PathVariable("policyId") int policyId, PolicyUpdateRequest request) {
        return ApiResponse.<PolicyResponse>builder().result(policyService.updatePolicy(policyId, request)).build();
    }
}
