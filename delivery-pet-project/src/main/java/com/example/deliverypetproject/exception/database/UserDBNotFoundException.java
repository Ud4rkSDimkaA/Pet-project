package com.example.deliverypetproject.exception.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDBNotFoundException extends RuntimeException {
    private String operation;
    private String errorDescription;
}
