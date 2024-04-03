package com.nagarro.cinservice.controller;

import com.nagarro.cinservice.constant.Constant;
import com.nagarro.cinservice.dto.ApiResponse;
import com.nagarro.cinservice.dto.CinDetailResponse;
import com.nagarro.cinservice.service.CinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cin")
public class CinController {
    @Autowired
    private CinService cinService;

    @PostMapping()
    public ResponseEntity<ApiResponse> saveCinDetails(@RequestParam String panNumber, @RequestParam double longitude, @RequestParam double latitude , @RequestParam long userId, @RequestPart MultipartFile file){

        CinDetailResponse data=cinService.saveCinDetails(file,panNumber,longitude,latitude,userId);

        ApiResponse apiResponse = new ApiResponse(null, HttpStatus.CREATED.value(), Constant.CIN_DETAILS_SAVED_SUCCESS, data );

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


}
