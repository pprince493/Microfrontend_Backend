package com.nagarro.kycservice.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.kycservice.dao.PanDummyDetailsRepository;
import com.nagarro.kycservice.dto.UserPanDetail;
import com.nagarro.kycservice.entity.PanDummyDetails;
import com.nagarro.kycservice.exception.WatermarkException;
import com.nagarro.kycservice.exception.WrongPanNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.kycservice.constant.Constant;
import com.nagarro.kycservice.dao.PanImageRepository;
import com.nagarro.kycservice.dto.UserPanImageRequest;
import com.nagarro.kycservice.entity.PanDetails;
import com.nagarro.kycservice.service.PanImageService;

@Service
public class PanImageServiceImpl implements PanImageService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PanImageRepository panImageRepository;
    @Autowired
    private PanDummyDetailsRepository panDummyDetailsRepository;

    @Override
    public UserPanDetail addWatermarkAndSaveDetails(UserPanImageRequest userPanImageRequest) {
        if (!isPanValid(userPanImageRequest.getPanNumber())) {
            throw new WrongPanNumberException("The given pan number is wrong. PAN: " + userPanImageRequest.getPanNumber());
        }
        UserPanDetail userPanDetail = new UserPanDetail();
        PanDummyDetails panDummyDetails = panDummyDetailsRepository.findById(userPanImageRequest.getPanNumber()).orElseThrow(() -> new WrongPanNumberException("PAN number doesn't exists!!"));
        userPanDetail.setName(panDummyDetails.getName());
        userPanDetail.setEntityType(getEntityType(userPanImageRequest.getPanNumber()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        try {
            body.add("file", new ByteArrayResource(userPanImageRequest.getImageFile().getBytes()) {
                @Override
                public String getFilename() {
                    return userPanImageRequest.getImageFile().getOriginalFilename();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        body.add("longitude", userPanImageRequest.getLongitude());
        body.add("latitude", userPanImageRequest.getLatitude());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        try {
            ResponseEntity<byte[]> response = restTemplate.exchange(Constant.WATERMARK_URL, HttpMethod.POST, requestEntity, byte[].class);

            byte[] waterMarkedImgFinal = response.getBody();

            PanDetails panDetails = new PanDetails();
            panDetails.setPanCardImage(waterMarkedImgFinal);
            panDetails.setUserId(userPanImageRequest.getUserId());
            panDetails.setPanNumber(userPanImageRequest.getPanNumber());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(userPanImageRequest.getDateOfIncorporation(), formatter);
            panDetails.setDateOfIncorporation(date);
            panDetails.setName(panDummyDetails.getName());
            PanDetails savedPanDetails = panImageRepository.save(panDetails);
            userPanDetail.setPanNumber(savedPanDetails.getPanNumber());
            userPanDetail.setDateOfIncorporation(userPanImageRequest.getDateOfIncorporation());
            return userPanDetail;
        } catch (HttpClientErrorException exception) {
            throw new WatermarkException(exception.getLocalizedMessage());
        }
    }

    private String getEntityType(String pan) {
        if (pan.charAt(Constant.INDEX) == Constant.THIRD_INDEX_C) {
            return Constant.COMPANY;
        } else if (pan.charAt(Constant.INDEX) == Constant.THIRD_INDEX_H) {
            return Constant.HUF;
        } else if (pan.charAt(Constant.INDEX) == Constant.THIRD_INDEX_P) {
            return Constant.INDIVIDUAL;
        } else if (pan.charAt(Constant.INDEX) == Constant.THIRD_INDEX_F) {
            return Constant.FIRM;
        } else if (pan.charAt(Constant.INDEX) == Constant.THIRD_INDEX_T) {
            return Constant.TRUST;
        } else {
            throw new WrongPanNumberException("The given pan number is wrong. PAN: " + pan);
        }
    }

    private boolean isPanValid(String panNumber) {
        String pattern = Constant.PAN_PATTERN;
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(panNumber);
        return matcher.matches();
    }
}
