package com.example.deliverypetproject.web;


import com.example.deliverypetproject.exception.database.UserErrorDescription;
import com.example.deliverypetproject.exception.validate.UserValidationException;
import com.example.deliverypetproject.exception.database.UserDBNotFoundException;
import com.example.deliverypetproject.exception.database.UserDBNotValidException;
import com.example.deliverypetproject.exception.validate.ValidationErrorDescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.ServerError;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(UserDBNotFoundException.class)
    public ResponseEntity<UserErrorDescription> processUserNotFoundException(UserDBNotFoundException exception) {
        //return ResponseEntity.ok(new UserErrorDescription(exception.getOperation(), exception.getErrorDescription()));
        return new ResponseEntity<>(new UserErrorDescription(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserDBNotValidException.class)
    public ResponseEntity<UserErrorDescription> processUserNotValidException(UserDBNotValidException exception) {
        return ResponseEntity.ok(new UserErrorDescription(exception.getOperation(), exception.getErrorDescription()));
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<UserErrorDescription> processServerError(ServerError error) {
        return ResponseEntity.ok(new UserErrorDescription("Server-exception","Something went wrong with server"));
    }

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<ValidationErrorDescription> processUserValidationException(UserValidationException exception){
        return ResponseEntity.ok(new ValidationErrorDescription(exception.getOperation(),exception.getErrorDescription(),exception.getFieldErrors()));
    }
}

