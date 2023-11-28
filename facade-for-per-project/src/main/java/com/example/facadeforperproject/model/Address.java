package com.example.facadeforperproject.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Address {

    private Long id;
    @NotNull
    @NotBlank
    private String street;
    @NotNull
    private Integer homeNumber;
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String country;
    private User user;
}
