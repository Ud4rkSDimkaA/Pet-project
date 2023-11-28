package com.example.deliverypetproject.repository;

import com.example.deliverypetproject.model.ROLE;
import com.example.deliverypetproject.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> getUserById(Long id);

    @Query(value = "select u from User u where u.username=:username")
    public Optional<User> getUserByUsername(String username);

    @Query(value = "select u from User u where u.dateOfBirthday=:birthday")
    public Optional<List<User>> getUsersWithBirthday(Date birthday);

    @Query(value = "select u from User u")
    public Optional<List<User>> getListOfUsers();

    @Modifying
    @Transactional
    @Query(value = "delete User u where u.id=:userId")
    public void deleteUserById(Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete User u where u.username=:username")
    public void deleteUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.username=:newUsername, u.isBlocked=:isBlocked,u.email=:email," +
            "u.password=:password,u.role=:role,u.dateOfBirthday=:date where u.id=:userId")
    public Optional<Void> updateUser(Long userId, @Param("newUsername") String newUsername,@Param("role") ROLE role,
                                     @Param("email") String email,@Param("password") String password,@Param("date") Date dateOfBirthday,
                                     @Param("isBlocked") boolean isBlocked);
}
