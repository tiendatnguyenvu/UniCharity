package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.PolicyViolationCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyViolationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.PolicyViolationResponse;
import com.UniCharity.UniCharity.services.PolicyViolationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy_violations")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PolicyViolationController {
    PolicyViolationService service;

    @PostMapping("/create")
    ApiResponse<PolicyViolationResponse> createPolicyViolation(@RequestBody @Valid PolicyViolationCreateRequest request) {
        return ApiResponse.<PolicyViolationResponse>builder().result(service.createPolicyViolation(request)).build();
    }

    @GetMapping
    ApiResponse<List<PolicyViolationResponse>> getPolicyViolations() {
        return ApiResponse.<List<PolicyViolationResponse>>builder().result(service.getPolicyViolations()).build();
    }

    @GetMapping("/get-by-id/{policyViolationId}")
    ApiResponse<PolicyViolationResponse> getPolicyViolation(@PathVariable("policyViolationId") int policyViolationId) {
        return ApiResponse.<PolicyViolationResponse>builder().result(service.getPolicyViolation(policyViolationId)).build();
    }

    @PutMapping("/update/{policyViolationId}")
    ApiResponse<PolicyViolationResponse> updatePolicyViolation(@PathVariable("policyViolationId") int policyViolationId,@RequestBody @Valid PolicyViolationUpdateRequest request) {
        return ApiResponse.<PolicyViolationResponse>builder().result(service.updatePolicyViolation(policyViolationId, request)).build();
    }
}