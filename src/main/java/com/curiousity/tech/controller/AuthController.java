package com.curiousity.tech.controller;

import com.curiousity.tech.domain.User;
import com.curiousity.tech.services.UserService;
import com.curiousity.tech.dto.AuthRequest; // Keep AuthRequest for username/password
// Removed JwtUtils, PasswordEncoder, AuthResponse
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    // Removed PasswordEncoder and JwtUtils dependencies
    // private final PasswordEncoder passwordEncoder;
    // private final JwtUtils jwtUtils;

    public AuthController(UserService userService /*, PasswordEncoder passwordEncoder, JwtUtils jwtUtils*/) {
        this.userService = userService;
        // this.passwordEncoder = passwordEncoder;
        // this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest req) {
        if (userService.existsByUsername(req.username())) {
            return ResponseEntity.badRequest().body("Username taken");
        }
        User u = new User();
        u.setUsername(req.username());
        u.setPassword(req.password()); // Storing plain text password
        // Removed setRoles
        userService.save(u);
        // No JWT token generation
        return ResponseEntity.ok("Registration successful"); // Simple success message
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        User u = userService.findByUsername(req.username());
        if (u == null) return ResponseEntity.status(401).body("Bad credentials");
        if (!u.getPassword().equals(req.password())) return ResponseEntity.status(401).body("Bad credentials"); // Plain text password check
        // No JWT token generation
        return ResponseEntity.ok("Login successful"); // Simple success message
    }
}
