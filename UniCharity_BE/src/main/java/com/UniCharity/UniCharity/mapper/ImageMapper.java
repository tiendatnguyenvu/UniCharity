package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.ImageCreateRequest;
import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.entities.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    @Mapping(target = "campaign", ignore = true)
    Image toImage(ImageCreateRequest imageCreateRequest);

    @Mapping(source = "campaign.id", target = "campaign")
    ImageResponse toImageResponse(Image image);
}
