package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.UserDto;
import com.example.sports_performance.Model.Role;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Repository.UserRepository;
import com.example.sports_performance.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public User createUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exists with this username.");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(jwtUtil.encodePassword(userDto.getPassword()));
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));
        return userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        userRepository.delete(user);
    }
}
