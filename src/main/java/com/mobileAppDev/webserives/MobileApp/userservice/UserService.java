package com.mobileAppDev.webserives.MobileApp.userservice;

import com.mobileAppDev.webserives.MobileApp.ui.model.request.UserDetailsRequestModel;
import com.mobileAppDev.webserives.MobileApp.ui.model.response.UserRest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
