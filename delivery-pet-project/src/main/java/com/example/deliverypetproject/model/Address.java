package com.example.deliverypetproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private User user;
}
