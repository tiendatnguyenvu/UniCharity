package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.PolicyViolationCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyViolationUpdateRequest;
import com.UniCharity.UniCharity.dto.response.PolicyViolationResponse;
import com.UniCharity.UniCharity.models.PolicyViolation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PolicyViolationMapper {
    @Mapping(target = "policy", ignore = true)
    PolicyViolation toPolicyViolation(PolicyViolationCreateRequest request);

    PolicyViolationResponse toPolicyViolationResponse(PolicyViolation policyViolation);

    void updatePolicyViolation(@MappingTarget PolicyViolation policyViolation, PolicyViolationUpdateRequest request);
}
