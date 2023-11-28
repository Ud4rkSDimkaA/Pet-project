package com.example.facadeforperproject.controller;

import com.example.facadeforperproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@RequestMapping("/api")
public class UserController {

    private static final String URL_TO_GET_ALL_USERS ="http://127.0.0.1:8080/api/v1/users/all";
    /*private static final String REGISTER_NEW_USER = "http:/.127.0.0.1:8081/api/v1/"*/

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getLoginPage(Model model){
        User[] forObject = restTemplate.getForObject(URL_TO_GET_ALL_USERS, User[].class);
        model.addAttribute("list", Arrays.asList(forObject));
        return "loginPage.html";
    }

    @GetMapping("/12")
    public String getRegistartionPage(Model model){
        User[] forObject = restTemplate.getForObject(URL_TO_GET_ALL_USERS, User[].class);
        model.addAttribute("list", Arrays.asList(forObject));
        return "registrationPage.html";
    }
}
