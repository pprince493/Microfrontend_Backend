package com.nagarro.kycservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.kycservice.constant.Constant;
import com.nagarro.kycservice.dto.ApiResponse;
import com.nagarro.kycservice.dto.UserPanImageRequest;
import com.nagarro.kycservice.service.PanImageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/pan")
public class PanController {
	@Autowired
	private PanImageService panImageService;

	@PostMapping
	@ApiOperation(value = Constant.UPLOAD, notes = Constant.NOTE_FOR_UPLOAD)
	public ResponseEntity<ApiResponse> savePanImage(@ApiParam(required = true) @RequestParam MultipartFile file,
			@ApiParam(required = true) @RequestParam String panNumber,
			@ApiParam(required = true) @RequestParam double longitude,
			@ApiParam(required = true) @RequestParam double latitude, @RequestParam String userId,
			@ApiParam(required = true) @RequestParam String dateOfIncorporation) {
		UserPanImageRequest userPanImageRequest = new UserPanImageRequest();
		userPanImageRequest.setImageFile(file);
		userPanImageRequest.setPanNumber(panNumber);
		userPanImageRequest.setLatitude(latitude);
		userPanImageRequest.setLongitude(longitude);
		userPanImageRequest.setUserId(userId);
		userPanImageRequest.setDateOfIncorporation(dateOfIncorporation);
		ApiResponse apiResponse = new ApiResponse(null, HttpStatus.CREATED.value(), "PAN image saved successfully!!",
				panImageService.addWatermarkAndSaveDetails(userPanImageRequest));
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}
}
