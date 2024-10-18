package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.PolicyResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.PolicyMapper;
import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.models.Policy;
import com.UniCharity.UniCharity.repositories.CampaignReportRepository;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.PolicyRepository;
import com.UniCharity.UniCharity.services.iservices.IPolicyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PolicyService implements IPolicyService {
    PolicyRepository policyRepository;
    CampaignRepository campaignRepository;
    PolicyMapper policyMapper;

    @Override
    public PolicyResponse createPolicy(PolicyCreateRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaign()).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        Policy policy = policyMapper.toPolicy(request);
        policy.setCampaign(campaign);
        policyRepository.save(policy);
        return policyMapper.toPolicyResponse(policy);
    }

    @Override
    public List<PolicyResponse> getPolicies() {
        return policyRepository.findAll().stream().map(policyMapper::toPolicyResponse).toList().reversed();
    }

    @Override
    public PolicyResponse getPolicy(int policyId) {
        return policyMapper.toPolicyResponse(policyRepository.findById(policyId).orElseThrow(() -> new AppException(ErrorCode.POLICY_NOT_EXISTED)));
    }

    @Override
    public PolicyResponse updatePolicy(int policyId, PolicyUpdateRequest request) {
        Policy policy = policyRepository.findById(policyId).orElseThrow(() -> new AppException(ErrorCode.POLICY_NOT_EXISTED));
        policyMapper.updatePolicy(policy, request);
        policyRepository.save(policy);
        return policyMapper.toPolicyResponse(policy);
    }
}
