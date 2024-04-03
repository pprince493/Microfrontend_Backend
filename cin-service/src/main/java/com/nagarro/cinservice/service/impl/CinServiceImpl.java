package com.nagarro.cinservice.service.impl;

import com.nagarro.cinservice.constant.Constant;
import com.nagarro.cinservice.convertor.Convertor;
import com.nagarro.cinservice.dao.CinDummyRepository;
import com.nagarro.cinservice.dao.CinRepository;
import com.nagarro.cinservice.dto.CinDummyResponse;
import com.nagarro.cinservice.dto.CinDetailResponse;
import com.nagarro.cinservice.entity.CinDummyEntity;
import com.nagarro.cinservice.entity.CinEntity;
import com.nagarro.cinservice.service.CinService;
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
import java.util.Optional;

@Service
public class CinServiceImpl implements CinService {

    @Autowired
    private Convertor convertor;

    @Autowired
    private CinRepository cinRepository;

    @Autowired
    private CinDummyRepository cinDummyRepository;

    @Override
    public CinDetailResponse saveCinDetails(MultipartFile file, String panNumber, double longitude, double latitude, long id) {


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

        byte[] imageResponse=null;

        ResponseEntity<byte[]> response = restTemplate.postForEntity(Constant.GetDataApiUrl, requestEntity, byte[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            imageResponse = response.getBody();
        } else {
            System.out.println(Constant.ApiCalledFailedErrorMsg);
        }

        System.out.println(imageResponse);

        //      there should be Api call for getting data from Income tax websites
        Optional<CinDummyEntity> cinDummyEntityOpt = cinDummyRepository.findById(id);
        CinDummyEntity cinDetailsEntity = cinDummyEntityOpt.get();
        CinDummyResponse cinDummyResponse = convertor.CinEntityToDummyResponseConvertor(cinDetailsEntity);

        CinEntity cinEntityResponse = convertor.CinDummyResponseToEntityConvertor(cinDummyResponse, imageResponse);

        CinEntity CinEntityOpt = cinRepository.save(cinEntityResponse);

        CinDetailResponse cinDetailResponse = convertor.CinEntityToPostDtoConvertor(CinEntityOpt,file.getOriginalFilename());

        return cinDetailResponse;
    }


}
