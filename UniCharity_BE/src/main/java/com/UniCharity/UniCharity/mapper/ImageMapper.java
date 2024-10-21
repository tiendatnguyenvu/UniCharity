package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.entities.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CampaignMapper.class)
public interface ImageMapper {
    ImageResponse toImageResponse(Image image);
}
