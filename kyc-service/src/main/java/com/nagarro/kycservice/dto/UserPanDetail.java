package com.nagarro.kycservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPanDetail {
    private String panNumber;
    private String name;
    private String entityType;
    private String dateOfIncorporation;

}
