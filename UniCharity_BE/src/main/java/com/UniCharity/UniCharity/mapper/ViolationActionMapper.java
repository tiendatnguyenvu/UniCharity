package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.ViolationActionCreateRequest;
import com.UniCharity.UniCharity.dto.request.ViolationActionUpdateRequest;
import com.UniCharity.UniCharity.dto.response.ViolationActionResponse;
import com.UniCharity.UniCharity.models.ViolationAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ViolationActionMapper {
    @Mapping(target = "violation", ignore = true)
    ViolationAction toViolationAction(ViolationActionCreateRequest request);

    @Mapping(source = "violation.id", target = "violation")
    ViolationActionResponse toViolationActionResponse(ViolationAction violationAction);

    void updateViolationAction(@MappingTarget ViolationAction violationAction, ViolationActionUpdateRequest request);
}
