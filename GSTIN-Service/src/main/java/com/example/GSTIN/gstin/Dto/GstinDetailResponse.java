package com.example.GSTIN.gstin.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GstinDetailResponse {

    private long id;
    private String panNumber;
    private String userId;
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
