package com.nagarro.microfrontend.loanoffer.exception.advice;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.microfrontend.loanoffer.exception.ResourceNotFound;
import com.nagarro.microfrontend.loanoffer.exception.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
	
	
	@ExceptionHandler(value = {ResourceNotFound.class})
	public ResponseEntity<ExceptionResponse> handlePinCodeNotFound(ResourceNotFound resourceNotFound){
		ExceptionResponse response=new ExceptionResponse(resourceNotFound.getMessage(),HttpStatus.NOT_FOUND,ZonedDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}


	

}
