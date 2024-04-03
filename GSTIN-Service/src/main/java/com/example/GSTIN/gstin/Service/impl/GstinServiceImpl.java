package com.example.GSTIN.gstin.Service.impl;

import com.example.GSTIN.gstin.Constant.Constant;
import com.example.GSTIN.gstin.Converter.Converter;
import com.example.GSTIN.gstin.Dao.GstinDummyRepository;
import com.example.GSTIN.gstin.Dao.GstinRepository;
import com.example.GSTIN.gstin.Dto.GstinDetailResponse;
import com.example.GSTIN.gstin.Dto.GstinDummyResponse;
import com.example.GSTIN.gstin.Entity.GstinDetails;
import com.example.GSTIN.gstin.Entity.GstinDummyDetails;
import com.example.GSTIN.gstin.Exception.GstinNotExistException;
import com.example.GSTIN.gstin.Service.GstinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "GstinServiceImpl")
public class GstinServiceImpl implements GstinService {

    @Autowired
    private Converter converter;

    @Autowired
    private GstinRepository gstinRepository;

    @Autowired
    private GstinDummyRepository gstinDummyRepository;


    @Override
    public GstinDetailResponse saveGstinDetails(double longitude, double latitude, String panNumber, String gstin, String userId, MultipartFile file) {
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();

        try {
            requestBody.add("file", new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        requestBody.add("longitude", longitude);
        requestBody.add("latitude", latitude);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        byte[] imageResponse = null;

        ResponseEntity<byte[]> response = restTemplate.postForEntity(Constant.GetDataApiUrl, requestEntity, byte[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            imageResponse = response.getBody();
        } else {
            System.out.println(Constant.ApiCalledFailedErrorMsg);
        }

        System.out.println(imageResponse);
        Optional<GstinDummyDetails> gstinDummyDetailsOptional = gstinDummyRepository.findByPanNumberAndGstinNumber(panNumber, gstin);
        GstinDummyDetails gstinDummyDetails = gstinDummyDetailsOptional.orElseThrow(() -> new GstinNotExistException("No gst exists!!"));
        GstinDummyResponse gstinDummyResponse = converter.GstinEntityToDummyResponseConvertor(gstinDummyDetails);
        GstinDetails gstinDetails = converter.GstinDummyResponseToEntityConvertor(gstinDummyResponse, imageResponse);
gstinDetails.setUserId(userId);
        GstinDetails gstinDetails1 = gstinRepository.save(gstinDetails);

        GstinDetailResponse gstinDetailResponse = converter.GstinEntityToPostDtoConvertor(gstinDetails1, file.getOriginalFilename());

        return gstinDetailResponse;

    }

    public List<GstinDummyResponse> getAllGstinByPanNumber(String panNumber) {
        Optional<List<GstinDummyDetails>> gstinDummyEntityOpt = gstinDummyRepository.findByPanNumber(panNumber);
        List<GstinDummyDetails> gstinDetailsEntity = gstinDummyEntityOpt.orElseThrow(() -> new GstinNotExistException("No Gstin Exists!!"));
        List<GstinDummyResponse> gstinDummyResponseList = gstinDetailsEntity.stream().map(converter::GstinEntityToDummyResponseConvertor).collect(Collectors.toList());
        return gstinDummyResponseList;

    }
}
