package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.ScholarshipCreateRequest;
import com.UniCharity.UniCharity.dto.request.ScholarshipUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ScholarshipResponse;
import com.UniCharity.UniCharity.models.Scholarship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ScholarshipMapper {
    @Mapping(target = "department", ignore = true)
    Scholarship toScholarship(ScholarshipCreateRequest request);

    @Mapping(source = "department.id", target = "department")
    ScholarshipResponse toScholarshipResponse(Scholarship scholarship);

    void updateScholarship(@MappingTarget Scholarship scholarship, ScholarshipUpdateRequest request);
}
