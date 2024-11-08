package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.image.ImageResponse;
import com.UniCharity.UniCharity.services.iservices.IImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageController {
    IImageService service;

    @PostMapping("/upload/illustration/{campaignId}")
    ApiResponse<ImageResponse> createImage(@RequestPart("image")MultipartFile image, @PathVariable("campaignId") int campaignId) throws IOException {
        return ApiResponse.<ImageResponse>builder().result(service.uploadImage(image, campaignId)).build();
    }

        @PostMapping("/upload-list/illustration/{campaignId}")
        ApiResponse<List<ImageResponse>> createImages(@RequestPart("image")List<MultipartFile> imageList, @PathVariable("campaignId") int campaignId) throws IOException {
            return ApiResponse.<List<ImageResponse>>builder().result(service.uploadImageList(imageList, campaignId)).build();
        }

    @GetMapping("/dowload-by-id/{imageId}")
    ApiResponse<ImageResponse> getImageById(@PathVariable("imageId") int imageId) {
        return ApiResponse.<ImageResponse>builder().result(service.dowloadImage(imageId)).build();
    }

    @GetMapping("/dowload-by-campaignId/{campaignId}")
    ApiResponse<List<ImageResponse>> getImageByCampaignId(@PathVariable("campaignId") int campaignId) {
        return ApiResponse.<List<ImageResponse>>builder().result(service.dowloadImageByCampaign(campaignId)).build();
    }

    @DeleteMapping("/delete/{imageId}")
    ApiResponse<List<ImageResponse>> removeImage(@PathVariable("imageId") int imageId) {
        return ApiResponse.<List<ImageResponse>>builder().result(service.removeImage(imageId)).build();
    }
}
