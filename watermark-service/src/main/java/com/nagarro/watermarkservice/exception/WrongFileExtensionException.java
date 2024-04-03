package com.nagarro.watermarkservice.exception;

public class WrongFileExtensionException extends RuntimeException{
    public WrongFileExtensionException(String fileExtension){
        super("Unsupported file format: " + fileExtension);
    }
}
