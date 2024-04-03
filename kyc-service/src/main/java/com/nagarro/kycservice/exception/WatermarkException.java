package com.nagarro.kycservice.exception;


import org.springframework.http.HttpStatus;

public class WatermarkException extends RuntimeException{
    public WatermarkException(String message){
        super(message);
    }
}
