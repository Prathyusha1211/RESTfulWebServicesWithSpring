package com.mobileAppDev.webserives.MobileApp.UserControllers;
import com.mobileAppDev.webserives.MobileApp.ui.model.request.UserDetailsRequestModel;
import com.mobileAppDev.webserives.MobileApp.ui.model.response.UserRest;
//import javax.validation.Valid;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users") // url is http://localhost:8080/users
public class UserControl {

    @GetMapping(value="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        UserRest user = new UserRest();
        user.setFirstName("Prathyu");
        user.setLastName("Melam");
        user.setEmail("melam@gmail.com");
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
        //return "get user was called with id "+userId;
    }

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue =
    "0") int page,@RequestParam(value="limit", defaultValue = "20") int limit,@RequestParam(value="sort", defaultValue = "desc", required = true) String sort) {
        return "get user was called with page "+page+" and limit "+limit+" and sort "+sort;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        System.out.println("user name "+userDetails.getFirstName());
        System.out.println("user name "+userDetails.getEmail());
        System.out.println("user name "+userDetails.getPassword());
        return new ResponseEntity<UserRest>(user, HttpStatus.BAD_REQUEST);
        //return "create user was called";
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
