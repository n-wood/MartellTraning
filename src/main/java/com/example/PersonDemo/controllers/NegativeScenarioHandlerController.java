package com.example.PersonDemo.controllers;

import com.example.PersonDemo.exceptions.BadRequestException;
import com.example.PersonDemo.exceptions.InvalidAgeException;
import com.example.PersonDemo.models.GenericErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;

@ControllerAdvice
public class NegativeScenarioHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value={BadRequestException.class})
    protected ResponseEntity<Object> handleInvalidAge(RuntimeException ex, WebRequest request) throws JsonProcessingException {
        GenericErrorResponse body = new GenericErrorResponse(
                ((InvalidAgeException)ex).ERROR_CODE,
                ex.getMessage());

        String strBody = new ObjectMapper().writeValueAsString(body);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, strBody, httpHeaders, HttpStatus.BAD_REQUEST, request);

    }

}
