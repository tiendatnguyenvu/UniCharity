package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.CampaignReportCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignReportUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.CampaignReportResponse;
import com.UniCharity.UniCharity.services.CampaignReportService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign_reports")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CampaignReportController {
    CampaignReportService campaignReportService;

    @PostMapping("/create")
    ApiResponse<CampaignReportResponse> createCampaignReport(@RequestBody @Valid CampaignReportCreateRequest request) {
        return ApiResponse.<CampaignReportResponse>builder().result(campaignReportService.createCampaignReport(request)).build();
    }

    @GetMapping
    ApiResponse<List<CampaignReportResponse>> getCampaignReports() {
        return ApiResponse.<List<CampaignReportResponse>>builder().result(campaignReportService.getCampaignReports()).build();
    }

    @GetMapping("/get-by-id/{campaignReportId}")
    ApiResponse<CampaignReportResponse> getCampaignReport(@PathVariable("campaignReportId") int campaignReportId) {
        return ApiResponse.<CampaignReportResponse>builder().result(campaignReportService.getCampaignReport(campaignReportId)).build();
    }

    @PutMapping("/update/{campaignReportId}")
    ApiResponse<CampaignReportResponse> updateCampaignReport(@PathVariable("campaignReportId") int campaignReportId,@RequestBody @Valid CampaignReportUpdateRequest request) {
        return ApiResponse.<CampaignReportResponse>builder().result(campaignReportService.updateCampaignReport(campaignReportId, request)).build();
    }
}
