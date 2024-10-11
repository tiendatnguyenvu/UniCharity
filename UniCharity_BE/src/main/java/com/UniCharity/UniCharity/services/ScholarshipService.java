package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.ScholarshipCreateRequest;
import com.UniCharity.UniCharity.dto.request.ScholarshipUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ScholarshipResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.ScholarshipMapper;
import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.models.Scholarship;
import com.UniCharity.UniCharity.repositories.DepartmentRepository;
import com.UniCharity.UniCharity.repositories.ScholarshipRepository;
import com.UniCharity.UniCharity.services.iservices.IScholarshipService;
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
public class ScholarshipService implements IScholarshipService {
    ScholarshipRepository scholarshipRepository;
    DepartmentRepository departmentRepository;
    ScholarshipMapper scholarshipMapper;

    @Override
    public ScholarshipResponse createScholarship(ScholarshipCreateRequest request) {
        Department department = departmentRepository.findById(request.getDepartment()).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        Scholarship scholarship = scholarshipMapper.toScholarship(request);
        scholarship.setDepartment(department);
        scholarship = scholarshipRepository.save(scholarship);
        return scholarshipMapper.toScholarshipResponse(scholarship);
    }

    @Override
    public List<ScholarshipResponse> getScholarships() {
        return scholarshipRepository.findAll().stream().map(scholarshipMapper::toScholarshipResponse).toList();
    }

    @Override
    public ScholarshipResponse getScholarship(int scholarshipId) {
        return scholarshipMapper.toScholarshipResponse(scholarshipRepository.findById(scholarshipId).orElseThrow(() -> new AppException(ErrorCode.SCHOLARSHIP_NOT_EXISTED)));
    }

    @Override
    public ScholarshipResponse updateScholarship(int scholarshipId, ScholarshipUpdateRequest request) {
        Scholarship scholarship = scholarshipRepository.findById(scholarshipId).orElseThrow(() -> new AppException(ErrorCode.SCHOLARSHIP_NOT_EXISTED));
        scholarshipMapper.updateScholarship(scholarship, request);
        return scholarshipMapper.toScholarshipResponse(scholarshipRepository.save(scholarship));
    }

    @Override
    public ScholarshipResponse updateScholarshipStatus(int scholarshipId) {
        Scholarship scholarship = scholarshipRepository.findById(scholarshipId).orElseThrow(() -> new AppException(ErrorCode.SCHOLARSHIP_NOT_EXISTED));
        scholarship.setStatus("closed");
        return scholarshipMapper.toScholarshipResponse(scholarshipRepository.save(scholarship));
    }
}
