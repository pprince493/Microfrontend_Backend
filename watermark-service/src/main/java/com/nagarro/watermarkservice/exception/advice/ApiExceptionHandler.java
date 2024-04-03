package com.nagarro.watermarkservice.exception.advice;

import com.nagarro.watermarkservice.dto.ApiResponse;
import com.nagarro.watermarkservice.exception.WrongFileExtensionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(WrongFileExtensionException.class)
    public ResponseEntity<String> WrongFileExtensionExceptionHandler(WrongFileExtensionException wrongFileExtensionException){
        return new ResponseEntity<>(wrongFileExtensionException.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
