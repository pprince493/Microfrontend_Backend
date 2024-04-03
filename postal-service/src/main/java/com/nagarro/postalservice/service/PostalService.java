package com.nagarro.postalservice.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nagarro.postalservice.dto.ApiResponse;

public interface PostalService {
	
//	boolean savePostalRecordsFromExcleToDb(MultipartFile file) throws IOException;
	
	
	ApiResponse getPostalRecordByPostalCode(long postalCode);
	
	ApiResponse verifyPinCodeIsBlackListed(long postalCode);
	
	

}
