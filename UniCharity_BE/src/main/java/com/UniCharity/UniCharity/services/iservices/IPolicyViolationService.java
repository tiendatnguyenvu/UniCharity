package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.PolicyViolationCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyViolationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.PolicyResponse;
import com.UniCharity.UniCharity.dto.response.PolicyViolationResponse;
import com.UniCharity.UniCharity.models.PolicyViolation;

import java.util.List;

public interface IPolicyViolationService {
    public PolicyViolationResponse createPolicyViolation(PolicyViolationCreateRequest request);
    public List<PolicyViolationResponse> getPolicyViolations();
    public PolicyViolationResponse getPolicyViolation(int policyViolationId);
    public PolicyViolationResponse updatePolicyViolation(int policyViolationId, PolicyViolationUpdateRequest request);
}
