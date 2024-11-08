package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.campaign.CampaignResponse;
import com.UniCharity.UniCharity.dto.response.page.PageResponse;
import com.UniCharity.UniCharity.entities.Donation;

import java.util.List;

public interface ICampaignService {
    public CampaignResponse createCampaign(CampaignCreateRequest request);
    public PageResponse<CampaignResponse> getCampaigns(int page, int size, String sort);
    public PageResponse<CampaignResponse> getCampaignsByStatus(String status, int page, int size, String sort);
    public CampaignResponse getCampaign(int campaignId);
    public List<Donation> getAllUserDonation(int campaignId);
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request);
    public CampaignResponse updateCampaignStatus(int campaignId);
    public CampaignResponse updateCampaignCurrentAmount(int campaignId, long amout);
}
