package com.example.facadeforperproject.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneNumber {

    private Long id;
    private Long userPhoneNumber;
    private User user;

    public PhoneNumber(Long userPhoneNumber, User user) {
        this.userPhoneNumber = userPhoneNumber;
        this.user = user;
    }
}
