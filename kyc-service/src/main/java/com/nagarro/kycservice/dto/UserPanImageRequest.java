package com.nagarro.kycservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPanImageRequest {
    private MultipartFile imageFile;
    private String panNumber;
    private double latitude;
    private double longitude;
    private String userId;
    private String dateOfIncorporation;
}
