package com.example.facadeforperproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserValidationException extends RuntimeException{
    private String operation;
    private String description;
    private List<FieldError> fieldErrors;
}
