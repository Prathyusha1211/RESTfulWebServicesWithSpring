package com.mobileAppDev.webserives.MobileApp.UserControllers;
import com.mobileAppDev.webserives.MobileApp.ui.model.exceptions.UserServiceException;
import com.mobileAppDev.webserives.MobileApp.ui.model.request.UpdateUserDetailsRequestModel;
import com.mobileAppDev.webserives.MobileApp.ui.model.request.UserDetailsRequestModel;
import com.mobileAppDev.webserives.MobileApp.ui.model.response.UserRest;
import com.mobileAppDev.webserives.MobileApp.userservice.UserServiceImplementation;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // url is http://localhost:8080/users
public class UserControl {

    Map<String, UserRest> users;

    @Autowired
    UserServiceImplementation userService;

    @GetMapping(value="/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){

        if(true) throw new UserServiceException("user service exception was thrown");

        if(users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }

        //return "get user was called with id "+userId;
    }

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value="limit", defaultValue = "20") int limit,
                          @RequestParam(value="sort", defaultValue = "desc", required = true) String sort) {
        return "get user was called with page "+page+" and limit "+limit+" and sort "+sort;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest user = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(user, HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value="/{userId}",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest updateUserDetails = users.get(userId);
        updateUserDetails.setFirstName(userDetails.getFirstName());
        updateUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, updateUserDetails);
        return updateUserDetails;
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
        //return "delete user was called";
    }

}
