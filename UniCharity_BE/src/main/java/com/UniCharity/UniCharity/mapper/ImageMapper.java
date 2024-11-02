package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.entities.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    @Mapping(source = "campaign.id", target = "campaign")
    ImageResponse toImageResponse(Image image);
}
