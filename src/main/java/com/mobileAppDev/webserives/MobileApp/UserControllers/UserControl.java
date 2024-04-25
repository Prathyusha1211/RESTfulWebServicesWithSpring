package com.mobileAppDev.webserives.MobileApp.UserControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users") // url is http://localhost:8080/users
public class UserControl {

    @GetMapping(value="/{userId}")
    public String getUser(@PathVariable String userId){
        return "get user was called with id "+userId;
    }

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue =
    "0")int page,@RequestParam(value="limit", defaultValue = "20") int limit,@RequestParam(value="sort", defaultValue = "desc", required = true) String sort) {
        return "get user was called with page "+page+" and limit "+limit+" and sort "+sort;
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
