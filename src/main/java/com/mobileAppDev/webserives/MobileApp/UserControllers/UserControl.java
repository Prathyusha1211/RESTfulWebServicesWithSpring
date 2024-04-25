package com.mobileAppDev.webserives.MobileApp.UserControllers;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // url is http://localhost:8080/users
public class UserControl {

    @GetMapping(value="/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was called with id "+userId;
    }

    @GetMapping()
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
