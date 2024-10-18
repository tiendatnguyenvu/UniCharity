package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignReportCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignReportUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignReportResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.CampaignReportMapper;
import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.models.CampaignReport;
import com.UniCharity.UniCharity.repositories.CampaignReportRepository;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.services.iservices.ICampaignReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CampaignReportService implements ICampaignReportService {
    CampaignReportRepository campaignReportRepository;
    CampaignRepository campaignRepository;
    CampaignReportMapper campaignReportMapper;

    @Override
    public CampaignReportResponse createCampaignReport(CampaignReportCreateRequest request) {
        Campaign campaign = campaignRepository.findById(request.getCampaign()).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        CampaignReport campaignReport = campaignReportMapper.toCamportReport(request);
        campaignReport.setCampaign(campaign);
        campaignReportRepository.save(campaignReport);
        return campaignReportMapper.toCamportRequestResponse(campaignReport);
    }

    @Override
    public List<CampaignReportResponse> getCampaignReports() {
        return campaignReportRepository.findAll().stream().map(campaignReportMapper::toCamportRequestResponse).toList().reversed();
    }

    @Override
    public CampaignReportResponse getCampaignReport(int camportReportId) {
        return campaignReportMapper.toCamportRequestResponse(campaignReportRepository.findById(camportReportId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_REPORT_NOT_EXISTED)));
    }

    @Override
    public CampaignReportResponse updateCampaignReport(int camportReportId, CampaignReportUpdateRequest request) {
        CampaignReport campaignReport = campaignReportRepository.findById(camportReportId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_REPORT_NOT_EXISTED));
        campaignReportMapper.updateCampaignReport(campaignReport, request);
        return campaignReportMapper.toCamportRequestResponse(campaignReportRepository.save(campaignReport));
    }
}
