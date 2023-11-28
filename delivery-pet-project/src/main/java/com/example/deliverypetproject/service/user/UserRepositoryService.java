package com.example.deliverypetproject.service.user;


import com.example.deliverypetproject.model.User;

import java.util.Date;
import java.util.List;

public interface UserRepositoryService {
    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public List<User> getUsersWithBirthday(Date birthday);

    public List<User> getBlockedUsersList();

    public List<User> getUnblockedUsersList();

    public List<User> getAllUsers();

    public User saveNewUser(User user);

    public void deleteUserById(Long userId);

    public void deleteUserByUsername(String username);

    public void updateUser(Long userId, User user);


}
