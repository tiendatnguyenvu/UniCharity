package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.DepartmentCreateRequest;
import com.UniCharity.UniCharity.dto.request.DepartmentUpdateRequest;
import com.UniCharity.UniCharity.dto.response.DepartmentResponse;
import com.UniCharity.UniCharity.models.Department;
import java.util.List;

public interface IDepartmentService {
    public DepartmentResponse createDepartment(DepartmentCreateRequest request);
    public List<DepartmentResponse> getDepartments();
    public DepartmentResponse getDepartment(int departmentId);
    public DepartmentResponse updateDepartment(int departmentId, DepartmentUpdateRequest request);
    public DepartmentResponse updateDepartmentStatus(int departmentId);
}
