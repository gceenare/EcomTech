package com.curiousity.tech.services;

import com.curiousity.tech.domain.User;
import java.util.List;

public interface IUserService {
    User save(User user);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    // You can add other methods as needed, e.g., for admin operations
    List<User> getAllUsers();
}
