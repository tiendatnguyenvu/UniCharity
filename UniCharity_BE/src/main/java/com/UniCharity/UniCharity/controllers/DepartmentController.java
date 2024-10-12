package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ApiResponse;
import com.UniCharity.UniCharity.dto.request.DepartmentCreateRequest;
import com.UniCharity.UniCharity.dto.request.DepartmentUpdateRequest;
import com.UniCharity.UniCharity.dto.response.DepartmentResponse;
import com.UniCharity.UniCharity.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping
    ApiResponse<DepartmentResponse> createDepartment(@RequestBody @Valid DepartmentCreateRequest request) {
        return ApiResponse.<DepartmentResponse>builder().result(departmentService.createDepartment(request)).build();
    }

    @GetMapping
    ApiResponse<List<DepartmentResponse>> getDepartments() {
        return ApiResponse.<List<DepartmentResponse>>builder().result(departmentService.getDepartments()).build();
    }

    @GetMapping("/{departmentId}")
    ApiResponse<DepartmentResponse> getDepartment(@PathVariable("departmentId") int departmentId) {
        return ApiResponse.<DepartmentResponse>builder().result(departmentService.getDepartment(departmentId)).build();
    }

    @PutMapping("/{departmentId}")
    ApiResponse<DepartmentResponse> updateDepartment(@PathVariable("departmentId") int departmentId, @RequestBody @Valid DepartmentUpdateRequest request) {
        return ApiResponse.<DepartmentResponse>builder().result(departmentService.updateDepartment(departmentId, request)).build();
    }

    @PutMapping("/update_status/{departmentId}")
    ApiResponse<DepartmentResponse> updateDepartmentStatus(@PathVariable("departmentId") int departmentId) {
        return ApiResponse.<DepartmentResponse>builder().result(departmentService.updateDepartmentStatus(departmentId)).build();
    }
}
