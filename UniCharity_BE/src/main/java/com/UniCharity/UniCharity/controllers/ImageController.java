package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.ImageCreateRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.services.ImageService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageController {
    ImageService service;

    @PostMapping("/upload/illustration/{campaignId}")
    ApiResponse<ImageResponse> createImage(@RequestPart("image")MultipartFile image, @PathVariable("campaignId") int campaignId) throws IOException {
        return ApiResponse.<ImageResponse>builder().result(service.uploadImage(image, campaignId)).build();
    }
}
