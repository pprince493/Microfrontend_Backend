package com.nagarro.cinservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinDetailResponse {

    private Long id;
    private String PanNumber;
    private String cinCertificateImageName;
    private String cinNumber;
    private String entityName;
    private String dateOfRegistration;
    private boolean status;
    private String EntityCategory;
    private String classOfCompany;

}
