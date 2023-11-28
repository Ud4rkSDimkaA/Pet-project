package com.example.facadeforperproject.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private ROLE role;
    private String password;
    private String email;
    private Date dateOfBirthday;
    private Date created;
    private Date updated;
    private boolean isBlocked;
    private List<PhoneNumber> phoneNumbers;
    private List<Address> addresses;

    public User(){}

    public User(String username, ROLE role, String password, String email, Date dateOfBirthday, Date created, Date updated, boolean isBlocked) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.created = created;
        this.updated = updated;
        this.isBlocked = isBlocked;
    }

    public User(String username, ROLE role, String password, String email, Date dateOfBirthday, boolean isBlocked) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.isBlocked = isBlocked;
    }

    public User(String username, ROLE role, String password, String email, Date dateOfBirthday, boolean isBlocked, List<PhoneNumber> phoneNumbers) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.isBlocked = isBlocked;
        this.phoneNumbers = phoneNumbers;
    }

}
