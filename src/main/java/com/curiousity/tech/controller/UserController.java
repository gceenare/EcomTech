package com.curiousity.tech.controller;

import com.curiousity.tech.services.UserService;
import com.curiousity.tech.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserController {
    @Autowired
    private UserService userService;


    public User createUser(String fullName, String email, String password, String phoneNumber, String role) {
        return userService.createUser(fullName, email, password, phoneNumber, role);
    }

    public Optional<User> getUserById(String id) {
        return userService.getUserById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    public boolean deleteUser(String id) {
        return userService.deleteUser(id);
    }

    public boolean authenticateUser(String email, String password) {
        return userService.authenticateUser(email, password);
    }

    public boolean isUserExists(String email) {
        return userService.isUserExists(email);
    }
}

