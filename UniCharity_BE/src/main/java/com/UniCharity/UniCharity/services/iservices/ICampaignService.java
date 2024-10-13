package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.dto.response.DepartmentResponse;
import com.UniCharity.UniCharity.models.Campaign;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICampaignService {
    public CampaignResponse createCampaign(CampaignCreateRequest request, MultipartFile file);
    public List<CampaignResponse> getCampaigns();
    public CampaignResponse getCampaign(int campaignId);
    public CampaignResponse updateCampaign(int campaignId, CampaignUpdateRequest request);
    public CampaignResponse updateCampaignStatus(int campaignId);
}
