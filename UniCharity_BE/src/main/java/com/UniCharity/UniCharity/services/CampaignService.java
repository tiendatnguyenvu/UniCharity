package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.CampaignMapper;
import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.models.User;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.DepartmentRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.ICampaignService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CampaignService implements ICampaignService {
    CampaignRepository campaignRepository;
    UserRepository userRepository;
    CampaignMapper campaignMapper;
    DepartmentRepository departmentRepository;

    @Override
    public CampaignResponse createCampaign(CampaignCreateRequest request) {
        User user = userRepository.findById(request.getCreatedBy()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        Campaign campaign = campaignMapper.toCampaign(request);
        campaign.setDepartment(department);
        campaign.setCreatedBy(user);
        campaign = campaignRepository.save(campaign);
        return campaignMapper.toCampaignResponse(campaign);
    }

    @Override
    public List<CampaignResponse> getCampaigns() {
        return campaignRepository.findAll().stream().map(campaignMapper::toCampaignResponse).toList();
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
