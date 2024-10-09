package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.services.iservices.ICampaignService;

import java.util.List;
import java.util.Optional;

public class CampaignService implements ICampaignService {

    @Override
    public CampaignResponse createCampaign(CampaignCreateRequest request) {
        return null;
    }

    @Override
    public List<CampaignResponse> getCampaigns() {
        return List.of();
    }

    @Override
    public CampaignResponse getCampaign(int campaignId) {
        return null;
    }

    @Override
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request) {
        return null;
    }

    @Override
    public CampaignResponse updateCampaignStatus(int campaignId) {
        return null;
    }
}
