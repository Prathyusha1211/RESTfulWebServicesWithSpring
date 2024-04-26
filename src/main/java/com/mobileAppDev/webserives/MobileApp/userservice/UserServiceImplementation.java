package com.mobileAppDev.webserives.MobileApp.userservice;

import com.mobileAppDev.webserives.MobileApp.ui.model.request.UserDetailsRequestModel;
import com.mobileAppDev.webserives.MobileApp.ui.model.response.UserRest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    Map<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId, user);

        return user;
    }
}
