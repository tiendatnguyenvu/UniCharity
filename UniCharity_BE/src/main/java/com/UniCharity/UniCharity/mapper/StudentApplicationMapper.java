package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.StudentApplicationCreateRequest;
import com.UniCharity.UniCharity.dto.request.StudentApplicationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.StudentApplicationResponse;
import com.UniCharity.UniCharity.models.StudentApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentApplicationMapper {
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "scholarship", ignore = true)
    StudentApplication toStudentApplication(StudentApplicationCreateRequest request);

    @Mapping(source = "student.id", target = "student")
    @Mapping(source = "scholarship.id", target = "scholarship")
    StudentApplicationResponse toStudentApplicationResponse(StudentApplication studentApplication);

    void updateStudentApplication(@MappingTarget StudentApplication studentApplication, StudentApplicationUpdateRequest request);
}
