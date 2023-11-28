package com.example.deliverypetproject.exception.validate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserValidationException extends RuntimeException{
    private String operation;
    private String errorDescription;
    private List<FieldError> fieldErrors;
}
