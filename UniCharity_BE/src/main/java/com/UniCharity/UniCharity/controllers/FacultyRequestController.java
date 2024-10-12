package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ApiResponse;
import com.UniCharity.UniCharity.dto.request.FacultyRequestCreate;
import com.UniCharity.UniCharity.dto.request.FacultyRequestUpdate;
import com.UniCharity.UniCharity.dto.response.FacultyRequestResponse;
import com.UniCharity.UniCharity.services.FacultyRequestService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty_request")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FacultyRequestController {
    FacultyRequestService facultyRequestService;

    @PostMapping
    ApiResponse<FacultyRequestResponse> createFacultyRequest(@RequestBody @Valid FacultyRequestCreate request) {
        return ApiResponse.<FacultyRequestResponse>builder().result(facultyRequestService.createFacultyRequest(request)).build();
    }

    @GetMapping
    ApiResponse<List<FacultyRequestResponse>> getFacultyRequests() {
        return ApiResponse.<List<FacultyRequestResponse>>builder().result(facultyRequestService.getFacultyRequests()).build();
    }

    @GetMapping("/{facultyRequestId}")
    ApiResponse<FacultyRequestResponse> getFacultyRequest(@PathVariable("facultyRequestId") int facultyRequestId) {
        return ApiResponse.<FacultyRequestResponse>builder().result(facultyRequestService.getFacultyRequest(facultyRequestId)).build();
    }

    @PutMapping("/{facultyRequestId}")
    ApiResponse<FacultyRequestResponse> updateFacultyRequest(@PathVariable("facultyRequestId") int facultyRequestId, @RequestBody @Valid FacultyRequestUpdate request) {
        return ApiResponse.<FacultyRequestResponse>builder().result(facultyRequestService.updateFacultyRequest(facultyRequestId, request)).build();
    }

    @PutMapping("/update_status/{facultyRequestId}")
    ApiResponse<FacultyRequestResponse> updateFacultyRequestStatus(@PathVariable("facultyRequestId") int facultyRequestId) {
        return ApiResponse.<FacultyRequestResponse>builder().result(facultyRequestService.updateFacultyRequestStatus(facultyRequestId)).build();
    }
}
