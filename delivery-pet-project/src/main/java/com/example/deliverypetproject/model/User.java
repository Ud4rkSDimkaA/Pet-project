package com.example.deliverypetproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User extends RepresentationModel<User> {
    //@JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username can't be null")
    @NotBlank(message = "Username can't be empty")
    @Size(min = 4, message = "Username has to have at least 5 characters")
    private String username;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can't be empty")
    @Size(min = 8, message = "Password has to have at least 8 characters")
    private String password;

    @NotBlank(message = "Email can't be empty")
    private String email;

    @NotNull(message = "Date of birthday can't be empty")
    private Date dateOfBirthday;
    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;
    private boolean isBlocked;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses;

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
