package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.ImageCreateRequest;
import com.UniCharity.UniCharity.dto.response.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IImageService {
    public ImageResponse uploadImage(MultipartFile imageFile, int campaignId) throws IOException;
}
