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
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ImageService implements IImageService {

    // MIME types được cho phép
    private final List<String> allowedMimeTypes = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/webp", "image/bmp", "image/tiff");

    ImageRepository imageRepository;
    CampaignRepository campaignRepository;
    ImageMapper imageMapper;

    @Override
    public ImageResponse uploadImage(MultipartFile imageFile, int campaignId) throws IOException {
        validateFile(imageFile); // Kiểm tra file hợp lệ
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new AppException(ErrorCode.CAMPAIGN_NOT_EXISTED));
        // Mã hóa file thành chuỗi Base64 (cần cân nhắc có nên lưu trữ như vậy không)
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

    public ImageResponse dowloadImage(int imageId) {
        return imageMapper.toImageResponse(imageRepository.findById(imageId).orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_EXISTED)));
    }

    // Phương thức kiểm tra tính hợp lệ của file
    public void validateFile(MultipartFile file) throws IOException {
        // Kiểm tra file có null hoặc rỗng không
        if (file == null || file.isEmpty()) {
            throw new AppException(ErrorCode.EMPTY_FILE);
        }
        // Lấy MIME type từ MultipartFile (không cần tạo file tạm)
        String mimeType = file.getContentType();
        // Kiểm tra MIME type có thuộc danh sách cho phép không
        if (!allowedMimeTypes.contains(mimeType)) {
            throw new AppException(ErrorCode.FILE_TYPE_NOT_SUPPORTED);
        }
    }
}
