package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.donation.DonationResponse;
import com.UniCharity.UniCharity.dto.response.page.PageResponse;
import com.UniCharity.UniCharity.services.iservices.IDonationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donation")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DonationController {
    IDonationService donationService;

    @GetMapping
    ApiResponse<PageResponse<DonationResponse>> getDonations (@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "donationDate") String sort) {
        return ApiResponse.<PageResponse<DonationResponse>>builder().result(donationService.getDonations(page, size, sort)).build();
    }

    @GetMapping("get-by-id/{donationId}")
    ApiResponse<DonationResponse> getDonation (@PathVariable("donationId") int donationId) {
        return ApiResponse.<DonationResponse>builder().result(donationService.getDonation(donationId)).build();
    }
}
