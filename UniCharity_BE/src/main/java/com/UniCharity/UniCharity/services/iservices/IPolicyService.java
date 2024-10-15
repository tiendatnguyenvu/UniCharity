package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.PolicyResponse;
import com.UniCharity.UniCharity.models.Policy;
import com.UniCharity.UniCharity.models.PolicyViolation;

import java.util.List;

public interface IPolicyService  {
    public PolicyResponse createPolicy(PolicyCreateRequest request);
    public List<PolicyResponse> getPolicies();
    public PolicyResponse getPolicy(int policyId);
    public PolicyResponse updatePolicy(int policyId, PolicyUpdateRequest request);
}
