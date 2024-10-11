package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.StudentApplicationCreateRequest;
import com.UniCharity.UniCharity.dto.request.StudentApplicationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.StudentApplicationResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.StudentApplicationMapper;
import com.UniCharity.UniCharity.models.Scholarship;
import com.UniCharity.UniCharity.models.StudentApplication;
import com.UniCharity.UniCharity.models.User;
import com.UniCharity.UniCharity.repositories.ScholarshipRepository;
import com.UniCharity.UniCharity.repositories.StudentApplicationRepository;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.IStudentApplicationService;
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
public class StudentApplicationService implements IStudentApplicationService {
    StudentApplicationRepository studentApplicationRepository;
    ScholarshipRepository scholarshipRepository;
    UserRepository userRepository;
    StudentApplicationMapper studentApplicationMapper;

    @Override
    public StudentApplicationResponse createStudentApplication(StudentApplicationCreateRequest request) {
        User student = userRepository.findByIdAndRole(request.getStudent(), "student").orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_EXISTED));
        Scholarship scholarship = scholarshipRepository.findById(request.getScholarship()).orElseThrow(() -> new AppException(ErrorCode.SCHOLARSHIP_NOT_EXISTED));
        if(scholarship.getStatus().equals("closed")) throw new AppException(ErrorCode.SCHOLARSHIP_CLOSED);
        StudentApplication studentApplication = studentApplicationMapper.toStudentApplication(request);
        studentApplication.setStudent(student);
        studentApplication.setScholarship(scholarship);
        studentApplication = studentApplicationRepository.save(studentApplication);
        return studentApplicationMapper.toStudentApplicationResponse(studentApplication);
    }

    @Override
    public List<StudentApplicationResponse> getStudentApplications() {
        return studentApplicationRepository.findAll().stream().map(studentApplicationMapper::toStudentApplicationResponse).toList();
    }

    @Override
    public StudentApplicationResponse getStudentApplication(int stuAppliId) {
        return studentApplicationMapper.toStudentApplicationResponse(studentApplicationRepository.findById(stuAppliId).orElseThrow(() -> new AppException(ErrorCode.STUDENTAPPLICATION_NOT_EXISTED)));
    }

    @Override
    public StudentApplicationResponse updateStuAppliStatus(int stuAppliId, StudentApplicationUpdateRequest request) {
        StudentApplication studentApplication = studentApplicationRepository.findById(stuAppliId).orElseThrow(() -> new AppException(ErrorCode.STUDENTAPPLICATION_NOT_EXISTED));
        studentApplication.setStatus(request.getStatus());
        return studentApplicationMapper.toStudentApplicationResponse(studentApplicationRepository.save(studentApplication));
    }

    @Override
    public void removeStudentApplication(int stuAppliId) {
        StudentApplication studentApplication = studentApplicationRepository.findById(stuAppliId).orElseThrow(() -> new AppException(ErrorCode.STUDENTAPPLICATION_NOT_EXISTED));
        try {
            studentApplicationRepository.delete(studentApplication);
        } catch (Exception e) {
            throw new AppException(ErrorCode.STUDENTAPPLICATION_DELETE_FAILED);
        }
    }
}
