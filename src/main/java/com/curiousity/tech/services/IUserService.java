package com.curiousity.tech.services;

import com.curiousity.tech.domain.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(String fullName, String email, String password, String phoneNumber, String role);
    Optional<User> getUserById(String id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(User user);
    boolean deleteUser(String id);
    boolean authenticateUser(String email, String password);
    boolean isUserExists(String email);
}
