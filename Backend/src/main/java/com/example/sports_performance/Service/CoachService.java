package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.CoachRequestDto;
import com.example.sports_performance.Model.Coach;
import com.example.sports_performance.Model.User;
import com.example.sports_performance.Repository.CoachRepository;
import com.example.sports_performance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService{

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private UserRepository userRepository;

    public Coach createProfile(CoachRequestDto coachRequestDto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        if (coachRepository.findByUserId(user.getId()).isPresent()) {
            throw new IllegalArgumentException("Coach profile already exists.");
        }

        Coach coach = new Coach();
        coach.setUser(user);
        coach.setFirstName(coachRequestDto.getFirstName());
        coach.setLastName(coachRequestDto.getLastName());
        coach.setBirthDate(coachRequestDto.getBirthDate());
        coach.setGender(coachRequestDto.getGender());
        coach.setCategory(coachRequestDto.getCategory());

        return coachRepository.save(coach);
    }

    public Coach editProfile(CoachRequestDto coachRequestDto, String username) {
        Coach coach = getProfile(username);
        coach.setFirstName(coachRequestDto.getFirstName());
        coach.setLastName(coachRequestDto.getLastName());
        coach.setBirthDate(coachRequestDto.getBirthDate());
        coach.setGender(coachRequestDto.getGender());
        coach.setCategory(coachRequestDto.getCategory());
        return coachRepository.save(coach);
    }

    public Coach getProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        return coachRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Coach profile not found."));
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public List<Coach> searchCoachesByName(String name) {
        return coachRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    public List<Coach> searchCoachesByCategory(String category) {
        return coachRepository.findByCategoryContainingIgnoreCase(category);
    }
}