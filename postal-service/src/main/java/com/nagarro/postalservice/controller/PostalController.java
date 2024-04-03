package com.nagarro.postalservice.controller;

import java.io.IOException;

import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.postalservice.constant.Constant;
import com.nagarro.postalservice.dto.ApiResponse;
import com.nagarro.postalservice.service.PostalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping("/postalRecords")
@Validated
public class PostalController {

	@Autowired
	@Qualifier("PostalServiceImpl")
	private PostalService postalService;

	@GetMapping("/{pinCode}")
	@ApiOperation(value = Constant.FIND_POSTAL_RECORD, notes = Constant.NOTE_FOR_GET_POSTAL_RECORD)
	public ResponseEntity<ApiResponse> getPostalRecordByPostalCode(
			@ApiParam(required = true) @PathVariable("pinCode") @Digits(integer = 6, fraction = 0, message = "PINCODE MUST BE OF 6 DIGITS") Long pinCode) {

		final ApiResponse apiResponse = postalService.getPostalRecordByPostalCode(pinCode);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

	@GetMapping("/isBlackListed/{pinCode}")
	@ApiOperation(value = Constant.VERIFY_POSTAL_CODE, notes = Constant.NOTE_FOR_VERIFY_POSTAL_CODE)
	public ResponseEntity<ApiResponse> verifyPinCodeIsBlackListed(
			@ApiParam(required = true) @PathVariable("pinCode") @Digits(integer = 6, fraction = 0, message = "PINCODE MUST BE OF 6 DIGITS") Long pinCode) {

		final ApiResponse apiResponse = postalService.verifyPinCodeIsBlackListed(pinCode);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

//	@PutMapping
//	public ResponseEntity<String> saveOrUpdateEmployeeDataFromFileTODB(@RequestParam("file") MultipartFile file)
//			throws IOException {
//
//		if (file.getSize() == 0) {
//			return new ResponseEntity<String>(file.getName() + " FILE IS EMPTY ", HttpStatus.BAD_REQUEST);
//		}
//
//		final Boolean status = postalService.savePostalRecordsFromExcleToDb(file);
//
//		if (!status) {
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(file.getName() + " File Not Uploaded");
//		}
//
//		return new ResponseEntity<String>(file.getName() + " UPLOADED SUCCESSFULLY", HttpStatus.OK);
//
//	}

}
