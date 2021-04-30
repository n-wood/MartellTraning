package com.example.PersonDemo.exceptions;

public class InvalidAgeException extends BadRequestException {

    public static final String ERROR_CODE = "N400";



    public InvalidAgeException(String message) {
        super(message);
    }
}
