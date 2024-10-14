package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.CampaignReportCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignReportUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignReportResponse;

import java.util.List;

public interface ICampaignReportService {
    public CampaignReportResponse createCampaignReport(CampaignReportCreateRequest request);
    public List<CampaignReportResponse> getCampaignReports();
    public CampaignReportResponse getCampaignReport(int camportReportId);
    public CampaignReportResponse updateCampaignReport(int camportReportId, CampaignReportUpdateRequest request);
}
