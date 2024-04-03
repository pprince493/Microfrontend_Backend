package com.example.GSTIN.gstin.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GstinDummyResponse {

    private long id;
    private MultipartFile gstinCertImg;
    private String panNumber;
//    private String userId;
    private String gstinNumber;
    private String gstinState;
    private String entityStatus;
    private String tradeName;
    private String natureOfBusiness;
    private LocalDate dateOfRegistration;
    private String hsnCode;
    private long annualTurnoverFromRange;
    private long annualTurnOverToRange;
    private String registeredAddress;
    private Boolean secondaryKyc;
}
