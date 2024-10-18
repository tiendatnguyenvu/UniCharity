package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.response.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {
    public ImageResponse uploadImage(MultipartFile imageFile, int campaignId) throws IOException;
    public List<ImageResponse> uploadImageList(List<MultipartFile> imageList, int campaignId) throws IOException;
    public ImageResponse dowloadImage(int imageId);
    public List<ImageResponse> dowloadImageByCampaign(int campaignId);
}
