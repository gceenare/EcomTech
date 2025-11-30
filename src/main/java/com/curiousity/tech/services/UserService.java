package com.curiousity.tech.services;

import com.curiousity.tech.domain.User;
import com.curiousity.tech.factory.UserFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private List<User> users;

    public UserService() {
        this.users = new java.util.ArrayList<>();
    }

    @Override
    public User createUser(String fullName, String email, String password, String phoneNumber, String role) {
        User user = UserFactory.create(fullName, email, password, phoneNumber, role);
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return new java.util.ArrayList<>(users);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> existing = getUserById(user.getId());
        if (existing.isPresent()) {
            users.remove(existing.get());
            users.add(user);
        }
        return user;
    }

    @Override
    public boolean deleteUser(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        Optional<User> user = getUserByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    @Override
    public boolean isUserExists(String email) {
        return getUserByEmail(email).isPresent();
    }
}
