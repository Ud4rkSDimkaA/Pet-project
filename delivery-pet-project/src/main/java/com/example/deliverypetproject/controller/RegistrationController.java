package com.example.deliverypetproject.controller;

import com.example.deliverypetproject.model.User;
import com.example.deliverypetproject.service.user.UserValidationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
@Tag(name = "Registration controller",description = "This controller is used to register new people")
public class RegistrationController {

    private final UserValidationService validationService;

    @GetMapping("/new")
    public ResponseEntity<User> registerNewUser(@Valid User user, BindingResult bindingResult){
       return null;
    }
}
