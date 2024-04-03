package com.nagarro.watermarkservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.watermarkservice.constant.Constant;
import com.nagarro.watermarkservice.service.WatermarkService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("watermark")
public class WatermarkController {
	@Autowired
	private WatermarkService watermarkService;

	@PostMapping(consumes = {"multipart/form-data"},produces = {"application/octet-stream"})
	@ApiOperation(value = Constant.UPLOAD, notes = Constant.NOTE_FOR_UPLOAD)
	public ResponseEntity<byte[]> addWatermark(@RequestParam MultipartFile file, @RequestParam double longitude,
			@RequestParam double latitude) {

		final byte[] image = watermarkService.addWatermark(file, longitude, latitude);

		return new ResponseEntity<byte[]>(image,HttpStatus.OK);
	}

}
