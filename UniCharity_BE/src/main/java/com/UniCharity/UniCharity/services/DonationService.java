package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.Donation;
import com.UniCharity.UniCharity.entities.User;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.DonationMapper;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.DonationRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.IDonationService;

public class DonationService implements IDonationService {
    CampaignRepository campaignRepository;
    UserRepository userRepository;
    DonationRepository donationRepository;
    DonationMapper donationMapper;

    @Override
    public DonationCreateRequest createDonation(DonationCreateRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaign()).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        User user = userRepository.findById(request.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Donation donation = donationMapper.toDonation(request);
        donation.setCampaign(campaign);
        donation.setUser(user);
        return null;
    }
}
