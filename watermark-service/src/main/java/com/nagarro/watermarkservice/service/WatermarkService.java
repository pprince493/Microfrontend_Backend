package com.nagarro.watermarkservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface WatermarkService {
    public  byte[] addWatermark(MultipartFile file, double longitude, double latitude);
}
