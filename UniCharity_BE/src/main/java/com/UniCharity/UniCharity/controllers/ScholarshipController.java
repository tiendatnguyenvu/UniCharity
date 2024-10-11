package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ApiResponse;
import com.UniCharity.UniCharity.dto.request.ScholarshipCreateRequest;
import com.UniCharity.UniCharity.dto.request.ScholarshipUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ScholarshipResponse;
import com.UniCharity.UniCharity.services.ScholarshipService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scholarship")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScholarshipController {
    ScholarshipService scholarshipService;

    @PostMapping
    ApiResponse<ScholarshipResponse> createScholarship(@RequestBody @Valid ScholarshipCreateRequest request) {
        return ApiResponse.<ScholarshipResponse>builder().result(scholarshipService.createScholarship(request)).build();
    }

    @GetMapping
    ApiResponse<List<ScholarshipResponse>> getScholarships() {
        return ApiResponse.<List<ScholarshipResponse>>builder().result(scholarshipService.getScholarships()).build();
    }

    @GetMapping("/{scholarshipId}")
    ApiResponse<ScholarshipResponse> getScholarship(@PathVariable("scholarshipId") int scholarshipId) {
        return ApiResponse.<ScholarshipResponse>builder().result(scholarshipService.getScholarship(scholarshipId)).build();
    }

    @PutMapping("/{scholarshipId}")
    ApiResponse<ScholarshipResponse> updateScholarship(@PathVariable("scholarshipId") int scholarshipId, @RequestBody ScholarshipUpdateRequest request) {
        return ApiResponse.<ScholarshipResponse>builder().result(scholarshipService.updateScholarship(scholarshipId, request)).build();
    }

    @PutMapping("/update_status/{scholarshipId}")
    ApiResponse<ScholarshipResponse> updateScholarshipStatus(@PathVariable("scholarshipId") int scholarshipId) {
        return ApiResponse.<ScholarshipResponse>builder().result(scholarshipService.updateScholarshipStatus(scholarshipId)).build();
    }
}
