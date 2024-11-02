package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.Role;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));

        try {
            userService.registerUser(user); // Call register with User object
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid role provided.");
        }
    }
}
