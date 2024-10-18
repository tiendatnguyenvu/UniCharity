package com.UniCharity.UniCharity.mapper;

import com.UniCharity.UniCharity.dto.request.ImageCreateRequest;
import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    @Mapping(target = "campaign", ignore = true)
    @Mapping(target = "imagePath", ignore = true)
    Image toImage(ImageCreateRequest request);

    ImageResponse toImageResponse(Image image);
}
