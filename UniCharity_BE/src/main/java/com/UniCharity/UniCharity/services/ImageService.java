package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.response.image.ImageResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.mapper.ImageMapper;
import com.UniCharity.UniCharity.entities.Campaign;
import com.UniCharity.UniCharity.entities.Image;
import com.UniCharity.UniCharity.repositories.CampaignRepository;
import com.UniCharity.UniCharity.repositories.ImageRepository;
import com.UniCharity.UniCharity.services.iservices.IImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ImageService implements IImageService {
    private final Cloudinary cloudinary;
    private final List<String> allowedMimeTypes = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/webp", "image/bmp", "image/tiff");
    ImageRepository imageRepository;
    CampaignRepository campaignRepository;

    @Override
    public ImageResponse uploadImage(MultipartFile imageFile, String imageType, int campaignId) throws IOException {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        return uploadImageToCloudinary(imageFile, imageType, campaign);
    }

    @Override
    public List<ImageResponse> uploadImages(List<MultipartFile> imageFiles, String imageType, int campaignId) throws IOException {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        List<ImageResponse> result = new ArrayList<>();
        for(MultipartFile file : imageFiles) {
            result.add(uploadImageToCloudinary(file, imageType, campaign));
        }
        return result;
    }


    @Override
    public ImageResponse dowloadImage(int imageId) {
        return ImageMapper.toImageResponse(imageRepository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_EXISTED)));
    }

    @Override
    public List<ImageResponse> dowloadImageByCampaign(int campaignId) {
        return imageRepository.findByCampaignId(campaignId).stream().map(ImageMapper::toImageResponse).toList();
    }

    @Override
    public List<ImageResponse> removeImage(int imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_EXISTED));
        imageRepository.delete(image);
        return imageRepository.findByCampaignId(image.getCampaign().getId()).stream().map(ImageMapper::toImageResponse).toList();
    }

    public ImageResponse uploadImageToCloudinary(MultipartFile imageFile, String imageType, Campaign campaign) throws IOException {
        assert imageFile.getOriginalFilename() != null;
        String publicValue = generatePublicString(imageFile.getOriginalFilename());
        String extension = getFileName(imageFile.getOriginalFilename())[1];
        File fileUpload = convert(imageFile);
        log.info("FileUpload í: {}", fileUpload);
        cloudinary.uploader().upload(fileUpload, ObjectUtils.asMap("public_id", publicValue));
        cleanDisk(fileUpload);
        String filePath = cloudinary.url().generate(StringUtils.join(publicValue, ".", extension));

        Image image = new Image();
        image.setCampaign(campaign);
        image.setImagePath(filePath);
        image.setImageType(imageType);
        imageRepository.save(image);

        return ImageMapper.toImageResponse(image);
    }

    private File convert(MultipartFile file) throws IOException {
        assert file.getOriginalFilename() != null;
        File convFile = new File(StringUtils.join(generatePublicString(file.getOriginalFilename()), getFileName(file.getOriginalFilename())[1]));
        try(InputStream is = file.getInputStream()) {
            Files.copy(is, convFile.toPath());
        }
        return convFile;
    }

    public void cleanDisk(File file) {
        try {
            log.info("file.toPath(): {}", file.toPath());
            Path filePath = file.toPath();
            Files.delete(filePath);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    public String generatePublicString(String originalName) {
        String fileName = getFileName(originalName)[0];
        return StringUtils.join(UUID.randomUUID().toString(), "_", fileName);
    }

    public String[] getFileName(String originalName) {
        return originalName.split("\\.");
    }
}
