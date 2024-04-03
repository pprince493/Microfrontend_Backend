package com.nagarro.kycservice.exception;

public class WrongPanNumberException extends RuntimeException {
    public WrongPanNumberException(String message){
        super(message);
    }
}
