package com.curiousity.tech.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor; // Keep NoArgsConstructor for JPA

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor // Keep NoArgsConstructor for JPA
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;

    // Removed roles field and its annotations
    // @ElementCollection(fetch = FetchType.EAGER)
    // @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    // @Column(name = "role")
    // private List<String> roles;

    // Manual constructor for convenience, replacing @AllArgsConstructor
    public User(Long id, String username, String fullName, String email, String password, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
