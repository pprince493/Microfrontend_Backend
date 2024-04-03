package com.example.GSTIN.gstin.Exception;

public class GstinNotExistException extends RuntimeException{
    public GstinNotExistException(String message){
        super(message);
    }
}
