package com.example.deliverypetproject.exception.database;

import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserErrorDescription {
    private String operation;
    private String errorDescription;

}
