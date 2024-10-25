package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.CampaignCreateRequest;
import com.UniCharity.UniCharity.dto.request.CampaignUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.CampaignResponse;
import com.UniCharity.UniCharity.dto.response.PageResponse;
import com.UniCharity.UniCharity.services.iservices.ICampaignService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
@CrossOrigin(origins = "http://localhost:5174")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CampaignController {
    ICampaignService campaignService;

    @PostMapping("/create")
    ApiResponse<CampaignResponse> createCampaign(@RequestBody @Valid CampaignCreateRequest request) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.createCampaign(request)).build();
    }

    @GetMapping
    ApiResponse<PageResponse<CampaignResponse>> getCampaigns(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "createdAt") String sort) {
        return ApiResponse.<PageResponse<CampaignResponse>>builder().result(campaignService.getCampaigns(page, size, sort)).build();
    }

    @GetMapping("/get-by-status/{status}")
    ApiResponse<PageResponse<CampaignResponse>> getCampaignByStatus(@PathVariable("status") String status, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "createdAt") String sort) {
        return ApiResponse.<PageResponse<CampaignResponse>>builder().result(campaignService.getCampaignsByStatus(status, page, size, sort)).build();
    }

    @GetMapping("/get-by-id/{campaignId}")
    ApiResponse<CampaignResponse> getCampaign(@PathVariable("campaignId") int campaignId) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.getCampaign(campaignId)).build();
    }

    @PutMapping("/update/{campaignId}")
    ApiResponse<CampaignResponse> updateCampaign(@PathVariable("campaignId") int campaignId, @RequestBody @Valid CampaignUpdateRequest request) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.updateCampaign(campaignId, request)).build();
    }

    @PutMapping("/update-status/{campaignId}")
    ApiResponse<CampaignResponse> updateCampaignStatus(@PathVariable("campaignId") int campaignId) {
        return ApiResponse.<CampaignResponse>builder().result(campaignService.updateCampaignStatus(campaignId)).build();
    }
}
