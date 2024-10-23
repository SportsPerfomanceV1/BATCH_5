package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // To securely store the password

    public void register(UserDto userDto) {
        // Map UserDto to User entity
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));  // Encrypt the password
        user.setRole(userDto.getRole());

        // Save the user in the database
        userRepository.save(user);
    }
}
