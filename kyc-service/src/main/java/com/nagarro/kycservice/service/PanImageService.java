package com.nagarro.kycservice.service;

import com.nagarro.kycservice.dto.UserPanDetail;
import com.nagarro.kycservice.dto.UserPanImageRequest;

import java.io.File;

public interface PanImageService {
    public UserPanDetail addWatermarkAndSaveDetails(UserPanImageRequest userPanImageRequest);
}
