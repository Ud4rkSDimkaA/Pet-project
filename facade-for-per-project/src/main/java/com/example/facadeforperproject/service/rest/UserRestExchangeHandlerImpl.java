package com.example.facadeforperproject.service.rest;

import com.example.facadeforperproject.model.User;
import com.example.facadeforperproject.service.rest.UserRestExchangeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRestExchangeHandlerImpl implements UserRestExchangeHandler {

    private static final String URL_TO_GET_ALL_USERS ="http://127.0.0.1:8080/api/v1/users/all";


    private final RestTemplate restTemplate;

    @Override
    public List<User> getAllUsers() {
        User[] forObject = restTemplate.getForObject(URL_TO_GET_ALL_USERS, User[].class);
        return Arrays.asList(forObject);
    }

    @Override
    public User getUserById() {
        return null;
    }


}
