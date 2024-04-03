package com.nagarro.kycservice.exception.advice;

import com.nagarro.kycservice.constant.Constant;
import com.nagarro.kycservice.dto.ApiResponse;
import com.nagarro.kycservice.exception.WatermarkException;
import com.nagarro.kycservice.exception.WrongPanNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.naming.SizeLimitExceededException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(WatermarkException.class)
    public ResponseEntity<ApiResponse> watermarkExceptionHandler(WatermarkException watermarkException){
        return new ResponseEntity<>(new ApiResponse(null, HttpStatus.BAD_REQUEST.value(),watermarkException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse> maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException maxUploadSizeExceededException){
        return new ResponseEntity<>(new ApiResponse(null, HttpStatus.BAD_REQUEST.value(), Constant.MAX_SIZE_EXCEEDED_MESSAGE, null), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SizeLimitExceededException.class)
    public ResponseEntity<ApiResponse> sizeLimitExceededExceptionHandler(SizeLimitExceededException sizeLimitExceededException){
        return new ResponseEntity<>(new ApiResponse(null, HttpStatus.BAD_REQUEST.value(), Constant.MAX_SIZE_EXCEEDED_MESSAGE, null), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WrongPanNumberException.class)
    public ResponseEntity<ApiResponse> wrongPanNumberExceptionHandler(WrongPanNumberException wrongPanNumberException){
        return new ResponseEntity<>(new ApiResponse(null, HttpStatus.BAD_REQUEST.value(), wrongPanNumberException.getMessage(), null),HttpStatus.BAD_REQUEST);
    }
}
