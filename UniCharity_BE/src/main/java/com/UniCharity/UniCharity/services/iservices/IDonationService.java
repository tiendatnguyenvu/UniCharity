package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;

public interface IDonationService {
    public DonationCreateRequest createDonation(DonationCreateRequest request);
}
