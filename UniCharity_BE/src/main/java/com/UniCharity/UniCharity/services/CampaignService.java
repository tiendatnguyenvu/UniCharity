package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.entities.Policy;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.CampaignMapper;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.User;
import com.UniCharity.UniCharity.mapper.PolicyMapper;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.PolicyRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.ICampaignService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CampaignService implements ICampaignService {
    CampaignRepository campaignRepository;
    UserRepository userRepository;
    PolicyRepository policyRepository;
    CampaignMapper campaignMapper;
    PolicyMapper policyMapper;

    @Override
    public CampaignResponse createCampaign(CampaignCreateRequest request) {
        User user = userRepository.findById(request.getCreatedBy()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Campaign campaign = campaignMapper.toCampaign(request);
        campaign.setCreatedBy(user);
        campaign = campaignRepository.save(campaign);
        // lưu policy
        List<Policy> policies = request.getPolicyCreateRequests().stream().map(policyMapper::toPolicy).toList();
        policyRepository.saveAll(policies);
        return campaignMapper.toCampaignResponse(campaign);
    }

    @Override
    public List<CampaignResponse> getCampaigns(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return campaignRepository.findAll(pageable)
                .map(campaignMapper::toCampaignResponse)
                .getContent();  // Lấy danh sách từ đối tượng Page
    }

    @Override
    public List<CampaignResponse> getCampaignsByStatus(String status, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return campaignRepository.findByStatus(status, pageable).stream().map(campaignMapper::toCampaignResponse).toList().reversed();
    }

    @Override
    public CampaignResponse getCampaign(int campaignId) {
        return campaignMapper.toCampaignResponse(campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED)));
    }

    @Override
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        campaignMapper.updateCampaign(campaign, request);
        return campaignMapper.toCampaignResponse(campaignRepository.save(campaign));
    }

    @Override
    public CampaignResponse updateCampaignStatus(int campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        campaign.setStatus("canceled");
        return campaignMapper.toCampaignResponse(campaignRepository.save(campaign));
    }
}
