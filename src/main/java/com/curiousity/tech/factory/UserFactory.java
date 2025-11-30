package com.curiousity.tech.factory;

import com.curiousity.tech.domain.User;
import com.curiousity.tech.util.Helper;

public class UserFactory {

    public static User create(String fullName, String email, String password, String phoneNumber, String role) {
        Helper.logDebug("Creating user: " + email);
        return new User.Builder()
                .setId(Helper.generateId())
                .setFullName(fullName)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setRole(role)
                .build();
    }

    public static User copy(User user) {
        Helper.logDebug("Copying user: " + user.getId());
        return new User.Builder()
                .copy(user)
                .build();
    }
}

