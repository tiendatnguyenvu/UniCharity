package com.UniCharity.UniCharity.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageResponse {
    Integer id;
    String imagePath;
    String imageType;

    int campaign;
}
