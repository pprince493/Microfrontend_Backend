package com.example.GSTIN.gstin.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GstinDummyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private String userId;
    private String panNumber;
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
