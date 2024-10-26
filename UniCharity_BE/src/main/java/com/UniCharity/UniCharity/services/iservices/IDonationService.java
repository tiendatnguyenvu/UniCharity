package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.dto.response.DonationResponse;
import com.UniCharity.UniCharity.entities.Donation;

public interface IDonationService {
    public DonationResponse createDonation(DonationCreateRequest request, String paymentMethod);
}
