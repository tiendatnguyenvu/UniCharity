package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICampaignService {
    public CampaignResponse createCampaign(CampaignCreateRequest request);
    public List<CampaignResponse> getCampaigns(int page, int size, String sort);
    public List<CampaignResponse> getCampaignsByStatus(String status, int page, int size, String sort);
    public CampaignResponse getCampaign(int campaignId);
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request);
    public CampaignResponse updateCampaignStatus(int campaignId);
}
