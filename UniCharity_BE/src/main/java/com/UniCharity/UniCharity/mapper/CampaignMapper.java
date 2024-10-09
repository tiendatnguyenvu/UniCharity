package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.DepartmentCreateRequest;
import com.UniCharity.UniCharity.dto.request.DepartmentUpdateRequest;
import com.UniCharity.UniCharity.dto.response.DepartmentResponse;
import com.UniCharity.UniCharity.models.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CampaignMapper {
    Department toDepartment(DepartmentCreateRequest request);
    DepartmentResponse toDepartmentResponse(Department department);
    void updateDepartment(@MappingTarget Department department, DepartmentUpdateRequest request);
}
