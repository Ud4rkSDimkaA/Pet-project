package com.example.deliverypetproject.exception.database;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDBNotValidException extends RuntimeException{
    private String operation;
    private String errorDescription;
}
