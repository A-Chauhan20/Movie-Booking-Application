package com.MovieBooking.User_Service.Controller;

import com.MovieBooking.User_Service.Entity.Role;
import com.MovieBooking.User_Service.Entity.User;
import com.MovieBooking.User_Service.Entity.UserRequest;
import com.MovieBooking.User_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request){
        try{
            if(request!=null){
                User user = new User(request.username, request.email, request.password, "USER");
                userService.registerUser(user);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>("User Registration Failed", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
