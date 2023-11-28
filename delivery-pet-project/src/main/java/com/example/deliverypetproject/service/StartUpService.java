package com.example.deliverypetproject.service;

import com.example.deliverypetproject.model.Address;
import com.example.deliverypetproject.model.PhoneNumber;
import com.example.deliverypetproject.model.ROLE;
import com.example.deliverypetproject.model.User;
import com.example.deliverypetproject.repository.PhoneRepository;
import com.example.deliverypetproject.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartUpService {
    private final UserRepository repository;
    private final PhoneRepository phoneRepository;

    @PostConstruct
    public void addUsersToDB(){
        User user = new User("Dima Prudnik",ROLE.CUSTOMER,"DimafromBelarus1",
                "dimaprudnik24@gmail.com",new Date(),new Date(),new Date(),false);
        repository.save(user);
        PhoneNumber phoneNumber = new PhoneNumber(375291755521L,user);
        phoneRepository.save(phoneNumber);
        Address address = Address.builder()
                .street("Lobanka")
                .homeNumber(97)
                .city("Minsk")
                .country("Belarus")
                .build();
        
        user.setPhoneNumbers(List.of(phoneNumber));
    }
}