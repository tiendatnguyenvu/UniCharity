package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.dto.response.PageResponse;
import com.UniCharity.UniCharity.entities.Image;
import com.UniCharity.UniCharity.entities.Policy;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.CampaignMapper;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.User;
import com.UniCharity.UniCharity.mapper.ImageMapper;
import com.UniCharity.UniCharity.mapper.PolicyMapper;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.ImageRepository;
import com.UniCharity.UniCharity.repositories.PolicyRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.ICampaignService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    ImageRepository imageRepository;
    CampaignMapper campaignMapper;
    PolicyMapper policyMapper;
    ImageMapper imageMapper;

    @Override
    public CampaignResponse createCampaign(CampaignCreateRequest request) {
        User user = userRepository.findById(request.getCreatedBy()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Campaign campaign = campaignMapper.toCampaign(request);
        campaign.setCreatedBy(user);
        campaign = campaignRepository.save(campaign);
        // lưu policy
        List<Policy> policies = request.getPolicyCreateRequests().stream().map(policyMapper::toPolicy).toList();
        for(Policy policy : policies) {
            policy.setCampaign(campaign);
        }
        policyRepository.saveAll(policies);
        // lưu image
        List<Image> images = request.getImageCreateRequests().stream().map(imageMapper::toImage).toList();
        for(Image image : images) {
            image.setCampaign(campaign);
        }
        imageRepository.saveAll(images);
        return campaignMapper.toCampaignResponse(campaign);
    }

    @Override
    public PageResponse<CampaignResponse> getCampaigns(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<CampaignResponse> campaignPage = campaignRepository.findAll(pageable).map(campaignMapper::toCampaignResponse);
        return new PageResponse<>(
                campaignPage.getContent(),
                com.UniCharity.UniCharity.dto.response.Page.builder()
                        .totalItem(campaignPage.getTotalElements())
                        .currentPage(campaignPage.getNumber())
                        .totalPages(campaignPage.getTotalPages())
                        .pageSize(campaignPage.getSize())
                        .build()
        );
    }

    @Override
    public PageResponse<CampaignResponse> getCampaignsByStatus(String status, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<CampaignResponse> campaignPage = campaignRepository.findByStatus(status, pageable).map(campaignMapper::toCampaignResponse);
        return new PageResponse<>(
                campaignPage.getContent(),
                com.UniCharity.UniCharity.dto.response.Page.builder()
                        .totalItem(campaignPage.getTotalElements())
                        .currentPage(campaignPage.getNumber())
                        .totalPages(campaignPage.getTotalPages())
                        .pageSize(campaignPage.getSize())
                        .build()
        );
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
