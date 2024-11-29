package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.DonationCreateRequest;
import com.UniCharity.UniCharity.dto.response.donation.DonationResponse;
import com.UniCharity.UniCharity.dto.response.page.PageResponse;

public interface IDonationService {
    public DonationResponse createDonation(DonationCreateRequest request, String paymentMethod);
    public PageResponse<DonationResponse> getDonations(int page, int size, String sort);
    public DonationResponse getDonation(int donationId);
    public PageResponse<DonationResponse> getDonationsByUserId(int userId, int page, int size, String sortField, String sortDirection);
    public PageResponse<DonationResponse> getDonationsByCampaignId(int campaignId, int page, int size, String sortField, String sortDirection);
}
