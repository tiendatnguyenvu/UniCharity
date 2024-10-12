package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.ScholarshipCreateRequest;
import com.UniCharity.UniCharity.dto.request.ScholarshipUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ScholarshipResponse;
import com.UniCharity.UniCharity.models.Scholarship;

import java.util.List;

public interface IScholarshipService {
    public ScholarshipResponse createScholarship(ScholarshipCreateRequest request);
    public List<ScholarshipResponse> getScholarships();
    public ScholarshipResponse getScholarship(int scholarshipId);
    public ScholarshipResponse updateScholarship(int scholarshipId, ScholarshipUpdateRequest request);
    public ScholarshipResponse updateScholarshipStatus(int scholarshipId);
}
