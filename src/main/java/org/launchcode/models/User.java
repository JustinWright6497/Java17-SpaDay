package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank
    @Size(min = 5, max = 15)
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public void checkPassword(){
        if(!password.isEmpty() && !verifyPassword.isEmpty() && !password.equals(verifyPassword)){
            verifyPassword = null;
        }
    }
}

