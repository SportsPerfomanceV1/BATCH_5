package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.LoginRequest;
import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Security.JwtUtil;
import com.example.sports_performance.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);
    }
}
