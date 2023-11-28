package com.example.deliverypetproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone_numbers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    private Long id;
    @NotNull(message = "Phone number can't be blank")
    private Long userPhoneNumber;
    @ManyToOne
    private User user;

    public PhoneNumber(Long userPhoneNumber, User user) {
        this.userPhoneNumber = userPhoneNumber;
        this.user = user;
    }
}
