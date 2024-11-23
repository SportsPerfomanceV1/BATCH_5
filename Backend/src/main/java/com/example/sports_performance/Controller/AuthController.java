package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.LoginDto;
import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Security.JwtUtil;
import com.example.sports_performance.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Register a new user
    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {
        User user = userService.createUser(userDto);
        return "User registered successfully!";
    }

    // Login a user
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        User user = userService.getUser(loginDto.getUsername());

        if (user != null && jwtUtil.validatePassword(loginDto.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user);
            return "JWT Token: " + token;
        } else {
            return "Invalid credentials!";
        }
    }
}