package com.ga.chat.model.request;

public class LoginRequest {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
