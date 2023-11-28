package com.example.facadeforperproject.service.rest;

import com.example.facadeforperproject.model.User;

import java.util.List;

public interface UserRestExchangeHandler {
    public List<User> getAllUsers();
    public User getUserById();

}
