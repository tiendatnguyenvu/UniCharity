package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ApiResponse;
import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.services.CampaignService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CampaignController {
    CampaignService campaignService;

    @PostMapping("/create")
    ApiResponse<CampaignResponse> createCampaign(@RequestBody @Valid CampaignCreateRequest request) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.createCampaign(request)).build();
    }

    @GetMapping()
    ApiResponse<List<CampaignResponse>> getCampaigns() {
        return ApiResponse.<List<CampaignResponse>>builder().result(campaignService.getCampaigns()).build();
    }

    @GetMapping("/get-by-id/{campaignId}")
    ApiResponse<CampaignResponse> getCampaign(@PathVariable("campaignId") int campaignId) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.getCampaign(campaignId)).build();
    }

    @PutMapping("/update/{campaignId}")
    ApiResponse<CampaignResponse> updateCampaign(@PathVariable("campaignId") int campaignId, @RequestBody @Valid CampaignUpdateRequest request) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.updateCampaign(campaignId, request)).build();
    }

    @PutMapping("/update_status/{campaignId}")
    ApiResponse<CampaignResponse> updateCampaignStatus(@PathVariable("campaignId") int campaignId) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.updateCampaignStatus(campaignId)).build();
    }
}
