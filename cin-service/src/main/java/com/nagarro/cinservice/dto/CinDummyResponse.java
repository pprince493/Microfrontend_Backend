package com.nagarro.cinservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinDummyResponse {

    private Long id;
    private String PanNumber;
    private MultipartFile cinCertificateImage;
    private String cinNumber;
    private String entityName;
    private String dateOfRegistration;
    private boolean status;
    private String EntityCategory;
    private String classOfCompany;
    private double latitude;
    private double longitude;


}
