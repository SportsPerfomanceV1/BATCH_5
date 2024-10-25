package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.LoginRequest;
import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    // Register user (athlete/admin)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        // Call service method to save user (you'll implement the service next)
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        // Validate user credentials and generate JWT
        return ResponseEntity.ok("JWT Token");
    }
}