package com.nagarro.cinservice.service;


import com.nagarro.cinservice.dto.CinDetailResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CinService {

    CinDetailResponse saveCinDetails(MultipartFile file, String panNumber, double longitude, double latitude, long userId);

}
