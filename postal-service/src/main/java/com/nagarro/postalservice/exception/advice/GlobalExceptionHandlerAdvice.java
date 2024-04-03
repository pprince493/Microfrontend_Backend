package com.nagarro.postalservice.exception.advice;

import java.io.IOException;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.postalservice.exception.InvalidRequest;
import com.nagarro.postalservice.exception.ResourceNotFound;
import com.nagarro.postalservice.exception.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
	
	
	@ExceptionHandler(value = {ResourceNotFound.class})
	public ResponseEntity<ExceptionResponse> handlePinCodeNotFound(ResourceNotFound resourceNotFound){
		ExceptionResponse response=new ExceptionResponse(resourceNotFound.getMessage(),HttpStatus.NOT_FOUND,ZonedDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {InvalidRequest.class})
	public ResponseEntity<ExceptionResponse> handleInvalidRequest(InvalidRequest invalidRequest){
		ExceptionResponse response=new ExceptionResponse(invalidRequest.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {IOException.class})
	public ResponseEntity<ExceptionResponse> handleIOException(IOException ioException){
		ExceptionResponse response=new ExceptionResponse(ioException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ZonedDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ExceptionResponse> handleException(Exception exception){
		ExceptionResponse response=new ExceptionResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ZonedDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
