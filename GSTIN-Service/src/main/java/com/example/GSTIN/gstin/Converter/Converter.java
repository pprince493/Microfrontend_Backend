package com.example.GSTIN.gstin.Converter;

import com.example.GSTIN.gstin.Dto.GstinDetailResponse;
import com.example.GSTIN.gstin.Dto.GstinDummyResponse;
import com.example.GSTIN.gstin.Entity.GstinDetails;
import com.example.GSTIN.gstin.Entity.GstinDummyDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    private ModelMapper modelMapper;

    public GstinDetails GstinDummyResponseToEntityConvertor(GstinDummyResponse gstinDummyResponse, byte[] imageBytes){
        GstinDetails gstinDetails = modelMapper.map(gstinDummyResponse,GstinDetails.class);
        gstinDetails.setGstinCertImg(imageBytes);
//        cinEntity.setPanNumber(cinGetDto.getPanNumber());
//        cinEntity.setCinCertificateImage(imageBytes);
//        cinEntity.setCinNumber(cinGetDto.getCinNumber());
//        cinEntity.setEntityName(cinGetDto.getEntityName());
//        cinEntity.setDateOfRegistration(cinGetDto.getDateOfRegistration());
//        cinEntity.setStatus(cinGetDto.isStatus());
//        cinEntity.setEntityCategory(cinGetDto.getEntityCategory());
//        cinEntity.setClassOfCompany(cinGetDto.getClassOfCompany());

        return gstinDetails;
    }

    public GstinDetailResponse GstinEntityToPostDtoConvertor(GstinDetails gstinDetails, String originalFilename){


        GstinDetailResponse gstinDetailResponse = modelMapper.map(gstinDetails, GstinDetailResponse.class);
//        gstinDetailResponse.setGstinCertImg(originalFilename);

//        cinPostDto.setPanNumber(cinEntity.getPanNumber());
//        cinPostDto.setCinCertificateImageName(originalFilename);
//        cinPostDto.setCinNumber(cinEntity.getCinNumber());
//        cinPostDto.setEntityName(cinEntity.getEntityName());
//        cinPostDto.setDateOfRegistration(cinEntity.getDateOfRegistration());
//        cinPostDto.setStatus(cinEntity.isStatus());
//        cinPostDto.setEntityCategory(cinEntity.getEntityCategory());
//        cinPostDto.setClassOfCompany(cinEntity.getClassOfCompany());
//        cinPostDto.setLocation(cinEntity.getLocation());
        return gstinDetailResponse;

    }

    public GstinDummyResponse GstinEntityToDummyResponseConvertor(GstinDummyDetails gstinDetailsEntity){

        GstinDummyResponse gstinDummyResponse = modelMapper.map(gstinDetailsEntity, GstinDummyResponse.class);


//        cinGetDto.setPanNumber(cinDummyEntity.getPanNumber());
//        cinGetDto.setCinNumber(cinDummyEntity.getCinNumber());
//        cinGetDto.setEntityName(cinDummyEntity.getEntityName());
//        cinGetDto.setDateOfRegistration(cinDummyEntity.getDateOfRegistration());
//        cinGetDto.setStatus(cinDummyEntity.isStatus());
//        cinGetDto.setEntityCategory(cinDummyEntity.getEntityCategory());
//        cinGetDto.setClassOfCompany(cinDummyEntity.getClassOfCompany());

        return gstinDummyResponse;
    }


}
