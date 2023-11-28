package com.example.deliverypetproject.dto;

import com.example.deliverypetproject.model.Address;
import com.example.deliverypetproject.model.PhoneNumber;
import com.example.deliverypetproject.model.ROLE;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto extends RepresentationModel<UserDto> {
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

    public UserDto(){}

    public UserDto(String username, ROLE role, String password, String email, Date dateOfBirthday, Date created, Date updated, boolean isBlocked) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.created = created;
        this.updated = updated;
        this.isBlocked = isBlocked;
    }

    public UserDto(Long id, String username, ROLE role, String password, String email, Date dateOfBirthday, Date created, Date updated, boolean isBlocked, List<PhoneNumber> phoneNumbers, List<Address> addresses) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.created = created;
        this.updated = updated;
        this.isBlocked = isBlocked;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public UserDto(String username, ROLE role, String password, String email, Date dateOfBirthday, Date created, Date updated, boolean isBlocked, List<PhoneNumber> phoneNumbers, List<Address> addresses) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.created = created;
        this.updated = updated;
        this.isBlocked = isBlocked;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }
}
