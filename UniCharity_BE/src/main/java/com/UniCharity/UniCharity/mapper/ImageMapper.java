package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.ImageCreateRequest;
import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CampaignMapper.class)
public interface ImageMapper {
    ImageResponse toImageResponse(Image image);
}
