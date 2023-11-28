package com.example.facadeforperproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping
    public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration&login-form");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView registerNewUser(ModelAndView modelAndView,
                                        @RequestParam(name = "email") String userEmail,
                                        @RequestParam(name = "password") String userPassword,
                                        @RequestParam(name = "cpassword") String confirmPassword) {
        if (userPassword.equals(confirmPassword)) {
            modelAndView.setViewName("main");
        } else {
            modelAndView.setViewName("registration&login-form");
        }
        return modelAndView;
    }
}
