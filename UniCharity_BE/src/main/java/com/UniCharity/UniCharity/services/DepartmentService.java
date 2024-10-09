package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.DepartmentCreateRequest;
import com.UniCharity.UniCharity.dto.request.DepartmentUpdateRequest;
import com.UniCharity.UniCharity.dto.response.DepartmentResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.DepartmentMapper;
import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.repositories.DepartmentRepository;
import com.UniCharity.UniCharity.services.iservices.IDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DepartmentService implements IDepartmentService {
    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        Department department = departmentMapper.toDepartment(request);
        department = departmentRepository.save(department);
        return departmentMapper.toDepartmentResponse(department);
    }

    @Override
    public List<DepartmentResponse> getDepartments() {
        return departmentRepository.findAll().stream().map(departmentMapper::toDepartmentResponse).toList();
    }

    @Override
    public DepartmentResponse getDepartment(int departmentId) {
        return departmentMapper.toDepartmentResponse(departmentRepository.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED)));
    }

    @Override
    public DepartmentResponse updateDepartment(int departmentId, DepartmentUpdateRequest request) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        departmentMapper.updateDepartment(department, request);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }

    @Override
    public DepartmentResponse updateDepartmentStatus(int departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        department.setStatus(false);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }
}
