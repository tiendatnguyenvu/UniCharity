package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ApiResponse;
import com.UniCharity.UniCharity.dto.request.StudentApplicationCreateRequest;
import com.UniCharity.UniCharity.dto.request.StudentApplicationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.StudentApplicationResponse;
import com.UniCharity.UniCharity.services.StudentApplicationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student_application")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class StudentApplicationController {
    StudentApplicationService studentApplicationService;

    @PostMapping
    ApiResponse<StudentApplicationResponse> createStudentApplication(@RequestBody @Valid StudentApplicationCreateRequest request) {
        return ApiResponse.<StudentApplicationResponse>builder().result(studentApplicationService.createStudentApplication(request)).build();
    }

    @GetMapping
    ApiResponse<List<StudentApplicationResponse>> getStudentApplications() {
        return ApiResponse.<List<StudentApplicationResponse>>builder().result(studentApplicationService.getStudentApplications()).build();
    }

    @GetMapping("/{stuAppliId}")
    ApiResponse<StudentApplicationResponse> getStudentApplication(@PathVariable("stuAppliId") int stuAppliId) {
        return ApiResponse.<StudentApplicationResponse>builder().result(studentApplicationService.getStudentApplication(stuAppliId)).build();
    }

    @PutMapping("/{stuAppliId}")
    ApiResponse<StudentApplicationResponse> updateStuAppliStatus(@PathVariable("stuAppliId") int stuAppliId, @RequestBody @Valid StudentApplicationUpdateRequest request) {
        return ApiResponse.<StudentApplicationResponse>builder().result(studentApplicationService.updateStuAppliStatus(stuAppliId, request)).build();
    }

    @DeleteMapping("/{stuAppliId}")
    ApiResponse<Void> removeStudentApplication(@PathVariable("stuAppliId") int stuAppliId) {
        studentApplicationService.removeStudentApplication(stuAppliId);
        return ApiResponse.<Void>builder().message("Student application deleted successfully").build();
    }
}
