package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.FacultyRequestCreate;
import com.UniCharity.UniCharity.dto.request.FacultyRequestUpdate;
import com.UniCharity.UniCharity.dto.response.FacultyRequestResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.FacultyRequestMapper;
import com.UniCharity.UniCharity.models.Department;
import com.UniCharity.UniCharity.models.FacultyRequest;
import com.UniCharity.UniCharity.models.User;
import com.UniCharity.UniCharity.repositories.DepartmentRepository;
import com.UniCharity.UniCharity.repositories.FacultyRequestRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.IFacultyRequestService;
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
public class FacultyRequestService implements IFacultyRequestService {
    FacultyRequestRepository facultyRequestRepository;
    UserRepository userRepository;
    DepartmentRepository departmentRepository;
    FacultyRequestMapper facultyRequestMapper;

    @Override
    public FacultyRequestResponse createFacultyRequest(FacultyRequestCreate request) {
        User user = userRepository.findByIdAndRole(request.getFaculty(), "faculty").orElseThrow(() -> new AppException(ErrorCode.FACULTY_NOT_EXISTED));
        Department department = departmentRepository.findById(request.getDepartment()).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        FacultyRequest facultyRequest = facultyRequestMapper.toFacultyRequest(request);
        facultyRequest.setFaculty(user);
        facultyRequest.setDepartment(department);
        facultyRequest = facultyRequestRepository.save(facultyRequest);
        return facultyRequestMapper.toFacultyRequestResponse(facultyRequest);
    }

    @Override
    public List<FacultyRequestResponse> getFacultyRequests() {
        return facultyRequestRepository.findAll().stream().map(facultyRequestMapper::toFacultyRequestResponse).toList();
    }

    @Override
    public FacultyRequestResponse getFacultyRequest(int facultyRequestId) {
        return facultyRequestMapper.toFacultyRequestResponse(facultyRequestRepository.findById(facultyRequestId).orElseThrow(() -> new AppException(ErrorCode.FACULTYREQUEST_NOT_EXISTED)));
    }

    @Override
    public FacultyRequestResponse updateFacultyRequest(int facultyRequestId, FacultyRequestUpdate request) {
        FacultyRequest facultyRequest = facultyRequestRepository.findById(facultyRequestId).orElseThrow(() -> new AppException(ErrorCode.FACULTYREQUEST_NOT_EXISTED));
        facultyRequestMapper.updateFacultyRequest(facultyRequest, request);
        return facultyRequestMapper.toFacultyRequestResponse(facultyRequestRepository.save(facultyRequest));
    }

    @Override
    public FacultyRequestResponse updateFacultyRequestStatus(int facultyRequestId) {
        FacultyRequest facultyRequest = facultyRequestRepository.findById(facultyRequestId).orElseThrow(() -> new AppException(ErrorCode.FACULTYREQUEST_NOT_EXISTED));
        facultyRequest.setStatus("cancelled");
        return facultyRequestMapper.toFacultyRequestResponse(facultyRequestRepository.save(facultyRequest));
    }
}
