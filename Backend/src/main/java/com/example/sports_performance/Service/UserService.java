package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDto userDto) {
        logger.info("Registering user: " + userDto.getUsername());

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());

        userRepository.save(user);
        logger.info("User registered successfully!");
    }
}
