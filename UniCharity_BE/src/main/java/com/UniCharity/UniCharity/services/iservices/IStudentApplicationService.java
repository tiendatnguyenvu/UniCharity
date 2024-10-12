package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.StudentApplicationCreateRequest;
import com.UniCharity.UniCharity.dto.request.StudentApplicationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.StudentApplicationResponse;
import com.UniCharity.UniCharity.models.StudentApplication;

import java.util.List;

public interface IStudentApplicationService {
    public StudentApplicationResponse createStudentApplication(StudentApplicationCreateRequest request);
    public List<StudentApplicationResponse> getStudentApplications();
    public StudentApplicationResponse getStudentApplication(int stuAppliId);
    public StudentApplicationResponse updateStuAppliStatus(int stuAppliId, StudentApplicationUpdateRequest request);
    public void removeStudentApplication(int stuAppliId);
}
