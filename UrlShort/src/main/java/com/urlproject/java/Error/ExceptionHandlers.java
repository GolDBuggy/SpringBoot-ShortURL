package com.urlproject.java.Error;

import com.urlproject.java.Exceptions.CustomerNotFoundException;
import com.urlproject.java.Exceptions.UrlMapException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userNotFound(CustomerNotFoundException exception){
        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> urlMap(UrlMapException exception){
        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> badReq(Exception exception){
        ErrorResponse response=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }


}
