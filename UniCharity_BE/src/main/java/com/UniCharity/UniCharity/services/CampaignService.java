package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.campaign.CampaignResponse;
import com.UniCharity.UniCharity.dto.response.page.PageResponse;
import com.UniCharity.UniCharity.entities.*;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.CampaignMapper;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CampaignService implements ICampaignService {
    CampaignRepository campaignRepository;
    UserRepository userRepository;


    @Override
    public CampaignResponse createCampaign(CampaignCreateRequest request) {
        User user = userRepository.findById(request.getCreatedBy()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Campaign campaign = CampaignMapper.toCampaign(request);
        campaign.setCreatedBy(user);
        campaign = campaignRepository.save(campaign);
        return CampaignMapper.toCampaignResponse(campaign);
    }

    @Override
    public PageResponse<CampaignResponse> getCampaigns(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<CampaignResponse> campaignPage = campaignRepository.findAll(pageable).map(CampaignMapper::toCampaignResponse);
        return new PageResponse<>(
                campaignPage.getContent(),
                com.UniCharity.UniCharity.dto.response.page.Page.builder()
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
        Page<CampaignResponse> campaignPage = campaignRepository.findByStatus(status, pageable).map(CampaignMapper::toCampaignResponse);
        return new PageResponse<>(
                campaignPage.getContent(),
                com.UniCharity.UniCharity.dto.response.page.Page.builder()
                        .totalItem(campaignPage.getTotalElements())
                        .currentPage(campaignPage.getNumber())
                        .totalPages(campaignPage.getTotalPages())
                        .pageSize(campaignPage.getSize())
                        .build()
        );
    }

    @Override
    public CampaignResponse getCampaign(int campaignId) {
        return CampaignMapper.toCampaignResponse(campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED)));
    }

    @Override
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        CampaignMapper.updateCampaign(campaign, request);
        return CampaignMapper.toCampaignResponse(campaignRepository.save(campaign));
    }

    @Override
    public CampaignResponse updateCampaignStatus(int campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        campaign.setStatus("canceled");
        return CampaignMapper.toCampaignResponse(campaignRepository.save(campaign));
    }

    @Override
    public CampaignResponse updateCampaignCurrentAmount(int campaignId, long amout) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        long newCurrentAmount = campaign.getCurrentAmount() + (amout/100);
        campaign.setCurrentAmount(newCurrentAmount);
        campaignRepository.save(campaign);
        return CampaignMapper.toCampaignResponse(campaign);
    }

    @Override
    public List<Donation> getAllUserDonation(int campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        List<Donation> userDonated = new ArrayList<>();
        for (Donation donation : campaign.getDonations()){
            boolean flag = false;
            for (Transaction transaction : donation.getTransactions()) {
                if(transaction.getTransactionStatus().equals("00")) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                userDonated.add(donation);
            }
        }
        return userDonated;
    }
}
