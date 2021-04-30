package com.example.PersonDemo.models;

public class GenericErrorResponse {

    private String errorCode;
    private String errorMessage;

    public GenericErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

}
