package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.PolicyCreateRequest;
import com.UniCharity.UniCharity.dto.request.PolicyUpdateRequest;
import com.UniCharity.UniCharity.dto.response.PolicyResponse;
import com.UniCharity.UniCharity.models.Policy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = CampaignMapper.class)
public interface PolicyMapper {
    @Mapping(target = "campaign", ignore = true)
    Policy toPolicy(PolicyCreateRequest request);

    @Mapping(source = "campaign", target = "campaign")
    PolicyResponse toPolicyResponse(Policy policy);

    void updatePolicy(@MappingTarget Policy policy, PolicyUpdateRequest request);
}
