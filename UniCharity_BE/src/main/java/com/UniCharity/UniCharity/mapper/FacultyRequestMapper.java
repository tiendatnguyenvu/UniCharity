package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.FacultyRequestCreate;
import com.UniCharity.UniCharity.dto.request.FacultyRequestUpdate;
import com.UniCharity.UniCharity.dto.response.FacultyRequestResponse;
import com.UniCharity.UniCharity.models.FacultyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FacultyRequestMapper {
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "department", ignore = true)
    FacultyRequest toFacultyRequest(FacultyRequestCreate request);

    @Mapping(source = "faculty.id", target = "faculty")
    @Mapping(source = "department.id", target = "department")
    FacultyRequestResponse toFacultyRequestResponse(FacultyRequest facultyRequest);

    void updateFacultyRequest(@MappingTarget FacultyRequest facultyRequest, FacultyRequestUpdate request);
}
