package com.UniCharity.UniCharity.dto.response;

import com.UniCharity.UniCharity.models.Campaign;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageResponse {
    Integer id;
    Campaign campaign;
    String imagePath;
    String imageType;
}
