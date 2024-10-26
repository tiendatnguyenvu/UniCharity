package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.dto.response.DonationResponse;
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
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DonationService implements IDonationService {
    CampaignRepository campaignRepository;
    UserRepository userRepository;
    DonationRepository donationRepository;
    DonationMapper donationMapper;

    @Override
    public DonationResponse createDonation(DonationCreateRequest request, String paymentMethod) {
        Campaign campaign = campaignRepository.findById(request.getCampaign()).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        User user = userRepository.findById(request.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Donation donation = donationMapper.toDonation(request);
        donation.setCampaign(campaign);
        donation.setUser(user);
        donation.setPaymentMethod(paymentMethod);
        donation = donationRepository.save(donation);
        return donationMapper.toDonationResponse(donation);
    }
}
