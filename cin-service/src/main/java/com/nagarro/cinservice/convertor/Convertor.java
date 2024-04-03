package com.nagarro.cinservice.convertor;

import com.nagarro.cinservice.dto.CinDummyResponse;
import com.nagarro.cinservice.dto.CinDetailResponse;
import com.nagarro.cinservice.entity.CinDummyEntity;
import com.nagarro.cinservice.entity.CinEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Convertor {

    @Autowired
    private final ModelMapper modelMapper;

    public Convertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CinEntity CinDummyResponseToEntityConvertor(CinDummyResponse cinDummyResponse, byte[] imageBytes){
        CinEntity cinEntity = modelMapper.map(cinDummyResponse,CinEntity.class);
        cinEntity.setCinCertificateImage(imageBytes);

        return cinEntity;
    }

    public CinDetailResponse CinEntityToPostDtoConvertor(CinEntity cinEntity, String originalFilename){
        
        CinDetailResponse cinDetailResponse = modelMapper.map(cinEntity, CinDetailResponse.class);
        cinDetailResponse.setCinCertificateImageName(originalFilename);

        return cinDetailResponse;

    }

    public CinDummyResponse CinEntityToDummyResponseConvertor(CinDummyEntity cinDummyEntity){


        return modelMapper.map(cinDummyEntity, CinDummyResponse.class);
    }


}
