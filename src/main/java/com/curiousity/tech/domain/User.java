package com.curiousity.tech.domain;

public class User {

    private String id;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;


    protected User () {
    }


    private User (Builder builder) {


        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
    }
        public String getId () {
            return id;
        }

        public String getFullName () {
            return fullName;
        }

        public String getEmail () {
            return email;
        }

        public String getPassword () {
            return password;
        }

        public String getPhoneNumber () {
            return phoneNumber;
        }

        public String getRole () {
            return role;
        }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String fullName;
        private String email;
        private String password;
        private String phoneNumber;
        private String role;

        public Builder setId (String id) {
            this.id = id;
            return this;
        }

        public Builder setFullName (String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setEmail (String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword (String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber (String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setRole (String role) {
            this.role = role;
            return this;
        }

        public Builder copy (User user) {
            this.id = user.id;
            this.fullName = user.fullName;
            this.email = user.email;
            this.password = user.password;
            this.phoneNumber = user.phoneNumber;
            this.role = user.role;
            return this;
        }

        public User build () {
            return new User(this);
        }


    }











}
