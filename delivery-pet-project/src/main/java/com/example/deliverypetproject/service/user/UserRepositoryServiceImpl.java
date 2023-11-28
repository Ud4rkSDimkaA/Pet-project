package com.example.deliverypetproject.service.user;


import com.example.deliverypetproject.exception.database.UserDBNotFoundException;
import com.example.deliverypetproject.exception.database.UserDBNotValidException;
import com.example.deliverypetproject.model.User;
import com.example.deliverypetproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id)
                .orElseThrow(() -> new UserDBNotFoundException("Get-operation", "User with such id is not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getListOfUsers()
                .orElseThrow(() -> new UserDBNotFoundException("Get-operation", "There are no users at all"));
    }

    @Override
    public User saveNewUser(User user) {
        if (user == null) {
            throw new UserDBNotValidException("Post-operation", "User is not valid to save");
        } else {

            return userRepository.save(user);
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        if (userRepository.getUserById(userId).isPresent()) {
            userRepository.deleteUserById(userId);
        } else {
            throw new UserDBNotFoundException("Delete-operation", "User with such an id doesn't exist");
        }
    }

    @Override
    public void deleteUserByUsername(String username) {
        if (userRepository.getUserByUsername(username).isPresent()) {
            userRepository.deleteUserByUsername(username);
        } else {
            throw new UserDBNotFoundException("Delete-operation", "User with such an username doesn't exist");
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username)
                .orElseThrow(() -> new UserDBNotFoundException("Get-operation", "User with such an username doesn't exist"));
    }

    @Override
    public List<User> getUsersWithBirthday(Date birthday) {
        return null;
    }

    @Override
    public List<User> getBlockedUsersList() {
        return null;
    }

    @Override
    public List<User> getUnblockedUsersList() {
        return null;
    }

    @Override
    public void updateUser(Long userId, User user) {
        userRepository.updateUser(userId, user.getUsername(), user.getRole(), user.getEmail(),
                        user.getPassword(), user.getDateOfBirthday(), user.isBlocked())
                .orElseThrow(() -> new UserDBNotFoundException("Update-operation", "User can't be updated"));
    }
}

