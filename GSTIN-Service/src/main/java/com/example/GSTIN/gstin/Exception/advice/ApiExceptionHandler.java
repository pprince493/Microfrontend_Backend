package com.example.GSTIN.gstin.Exception.advice;

import com.example.GSTIN.gstin.Dto.ApiResponse;
import com.example.GSTIN.gstin.Exception.GstinNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(GstinNotExistException.class)
    public ResponseEntity<ApiResponse> GstinNotExistExceptionHandler(GstinNotExistException gstinNotExistException){
        return new ResponseEntity<>(new ApiResponse(null, HttpStatus.BAD_REQUEST.value(), gstinNotExistException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
