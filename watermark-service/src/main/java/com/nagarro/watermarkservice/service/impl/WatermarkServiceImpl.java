package com.nagarro.watermarkservice.service.impl;

import com.nagarro.watermarkservice.exception.WrongFileExtensionException;
import com.nagarro.watermarkservice.helper.ImageHelper;
import com.nagarro.watermarkservice.service.GeocodingService;
import com.nagarro.watermarkservice.service.WatermarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
@Service
public class WatermarkServiceImpl implements WatermarkService {
    @Autowired
    private GeocodingService geocodingService;
    @Autowired
    private ImageHelper imageHelper;
    @Override
    public byte[] addWatermark(MultipartFile file, double longitude, double latitude) {
        String fileExtension = imageHelper.getFileExtension(Objects.requireNonNull(file.getOriginalFilename()));
        String location = geocodingService.getLocationFromCoordinates(latitude, longitude);
        byte[] imageBytes = null;
        if ("pdf".equalsIgnoreCase(fileExtension)) {
            imageBytes = imageHelper.addWatermarkToPDF(file, location);
        }else if ("jpg".equalsIgnoreCase(fileExtension) || "jpeg".equalsIgnoreCase(fileExtension) || "png".equalsIgnoreCase(fileExtension)){
            imageBytes = imageHelper.addWatermarkToImage(file, location);
        }
        else{
            throw new WrongFileExtensionException(fileExtension);
        }
        System.out.println("Service: "+ file.getOriginalFilename());
        return imageBytes;
    }
}
