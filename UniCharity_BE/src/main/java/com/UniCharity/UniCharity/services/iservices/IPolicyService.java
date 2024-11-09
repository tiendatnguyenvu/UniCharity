package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.policy.PolicyResponse;

import java.util.List;

public interface IPolicyService  {
    public PolicyResponse createPolicy(PolicyCreateRequest request);
    public List<PolicyResponse> createPolicyList(List<PolicyCreateRequest> requests, int campaignId);
    public List<PolicyResponse> getPolicies();
    public PolicyResponse getPolicy(int policyId);
    public PolicyResponse updatePolicy(int policyId, PolicyUpdateRequest request);
    public List<PolicyResponse> updateListPolicies (int campaignId);
}
