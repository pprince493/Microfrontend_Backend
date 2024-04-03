package com.nagarro.productservice.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.productservice.dto.ApiResponse;
import com.nagarro.productservice.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { ProductNotFoundException.class })
	public ResponseEntity<ApiResponse> handleItemNotFoundException(ProductNotFoundException e) {
		ApiResponse response = new ApiResponse();
		response.setStatusCode(404);
		response.setMessage(e.getMessage());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<ApiResponse> handleRunTimeException(RuntimeException e) {
		ApiResponse response = new ApiResponse();
		response.setStatusCode(500);
		response.setMessage(e.getMessage());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
