package com.mobileAppDev.webserives.MobileApp.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Validator;

public class UserDetailsRequestModel {
    @NotNull(message = "First name can't be empty")
    @Size(min=2,message = "First name should contain atleast 2 chars")
    private String firstName;
    @NotNull(message = "Last name can't be empty")
    @Size(min=2,message = "Last name should contain atleast 2 chars")
    private String lastName;
    @NotNull(message = "Email can't be empty")
    @Email
    private String email;
    @NotNull(message = "Password can't be empty")
    @Size(min=8, max=12, message = "Password should be minimum 8 characters upto 12 chars")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    }
}
