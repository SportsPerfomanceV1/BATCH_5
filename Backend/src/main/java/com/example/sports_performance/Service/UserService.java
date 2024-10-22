package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.LoginRequest;
import com.example.sports_performance.DTO.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // This method will be called when registering users
    public void register(UserDto userDto) {
        // Logic to store the user into the database (You will implement this next)
    }

    // This method will authenticate users (login)
    public String authenticate(LoginRequest loginRequest) {
        // Logic to authenticate and generate JWT
        return "JWT Token";
    }
}

