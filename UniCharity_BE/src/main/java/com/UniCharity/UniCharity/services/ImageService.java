package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.response.ImageResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.ImageMapper;
import com.UniCharity.UniCharity.models.Campaign;
import com.UniCharity.UniCharity.models.Image;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.ImageRepository;
import com.UniCharity.UniCharity.services.iservices.IImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ImageService implements IImageService {
    private final List<String> allowedMimeTypes = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/webp", "image/bmp", "image/tiff");
    ImageRepository imageRepository;
    CampaignRepository campaignRepository;
    ImageMapper imageMapper;

    @Override
    public ImageResponse uploadImage(MultipartFile imageFile, int campaignId) throws IOException {
        validateFile(imageFile); // Kiểm tra file hợp lệ
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        byte[] fileContent = imageFile.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        String imageDataUrl = "data:" + imageFile.getContentType() + ";base64," + encodedString;
        Image image = new Image();
        image.setCampaign(campaign);
        image.setImagePath(imageDataUrl);
        image.setImageType("illustration");
        imageRepository.save(image);
        return imageMapper.toImageResponse(image);
    }

    @Override
    public List<ImageResponse> uploadImageList(List<MultipartFile> imageList, int campaignId) throws IOException {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        List<ImageResponse> imageResponseList = new ArrayList<>();
        for (MultipartFile imageItem : imageList) {
            byte[] fileContent = imageItem.getBytes();
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            String imageDataUrl = "data:" + imageItem.getContentType() + ";base64," + encodedString;
            Image image = new Image();
            image.setCampaign(campaign);
            image.setImagePath(imageDataUrl);
            image.setImageType("illustration");
            imageRepository.save(image);
            imageResponseList.add(imageMapper.toImageResponse(image));
        }
        return imageResponseList;
    }

    @Override
    public ImageResponse dowloadImage(int imageId) {
        return imageMapper.toImageResponse(imageRepository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_EXISTED)));
    }

    @Override
    public List<ImageResponse> dowloadImageByCampaign(int campaignId) {
        return imageRepository.findByCampaignId(campaignId).stream().map(imageMapper::toImageResponse).toList();
    }

    @Override
    public ImageResponse removeImage(int imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_EXISTED));
        imageRepository.delete(image);
        return imageMapper.toImageResponse(image);
    }

    public void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new AppException(ErrorCode.EMPTY_FILE);
        }
        String mimeType = file.getContentType();
        if (!allowedMimeTypes.contains(mimeType)) {
            throw new AppException(ErrorCode.FILE_TYPE_NOT_SUPPORTED);
        }
    }
}
