package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.FacultyRequestCreate;
import com.UniCharity.UniCharity.dto.request.FacultyRequestUpdate;
import com.UniCharity.UniCharity.dto.response.FacultyRequestResponse;
import com.UniCharity.UniCharity.models.FacultyRequest;

import java.util.List;

public interface IFacultyRequestService {
    public FacultyRequestResponse createFacultyRequest(FacultyRequestCreate request);
    public List<FacultyRequestResponse> getFacultyRequests();
    public FacultyRequestResponse getFacultyRequest(int facultyRequestId);
    public FacultyRequestResponse updateFacultyRequest(int facultyRequestId, FacultyRequestUpdate request);
    public FacultyRequestResponse updateFacultyRequestStatus(int facultyRequestId);
}
