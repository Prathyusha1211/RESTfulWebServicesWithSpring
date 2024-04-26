package com.mobileAppDev.webserives.MobileApp.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "First name can't be empty")
    @Size(min=2,message = "First name should contain atleast 2 chars")
    private String firstName;
    @NotNull(message = "Last name can't be empty")
    @Size(min=2,message = "Last name should contain atleast 2 chars")
    private String lastName;

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
}
