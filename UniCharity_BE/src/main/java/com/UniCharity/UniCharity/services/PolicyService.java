package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.policy.PolicyResponse;
import com.UniCharity.UniCharity.dto.response.policy.PolicySimple;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.Policy;
import com.UniCharity.UniCharity.mapper.PolicyMapper;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.PolicyRepository;
import com.UniCharity.UniCharity.services.iservices.IPolicyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PolicyService implements IPolicyService {
    PolicyRepository policyRepository;
    CampaignRepository campaignRepository;

    @Override
    public PolicyResponse createPolicy(PolicyCreateRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaign()).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        Policy policy = PolicyMapper.toPolicy(request);
        policy.setCampaign(campaign);
        policyRepository.save(policy);
        return PolicyMapper.toPolicyResponse(policy);
    }

    @Override
    public List<PolicyResponse> createPolicyList(List<PolicyCreateRequest> requests, int campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        List<Policy> policies = requests.stream().map(PolicyMapper::toPolicy).toList();
        for (Policy policy : policies) {
            policy.setCampaign(campaign);
        }
        policyRepository.saveAll(policies);
        return policies.stream().map(PolicyMapper::toPolicyResponse).toList();
    }


    @Override
    public List<PolicyResponse> getPolicies() {
        return policyRepository.findAll().stream().map(PolicyMapper::toPolicyResponse).toList().reversed();
    }

    @Override
    public PolicyResponse getPolicy(int policyId) {
        return PolicyMapper.toPolicyResponse(policyRepository.findById(policyId).orElseThrow(() -> new AppException(ErrorCode.POLICY_NOT_EXISTED)));
    }

    @Override
    public PolicyResponse updatePolicy(int policyId, PolicyUpdateRequest request) {
        Policy policy = policyRepository.findById(policyId).orElseThrow(() -> new AppException(ErrorCode.POLICY_NOT_EXISTED));
        PolicyMapper.updatePolicy(policy, request);
        return PolicyMapper.toPolicyResponse(policyRepository.save(policy));
    }
}
