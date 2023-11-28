package com.example.deliverypetproject.exception.phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneNotFoundException extends RuntimeException{
    private String operation;
    private String errorDescription;
}
