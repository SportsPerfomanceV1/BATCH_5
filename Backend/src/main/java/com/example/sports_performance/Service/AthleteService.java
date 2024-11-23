package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.AthleteRequestDto;
import com.example.sports_performance.Model.Athlete;
import com.example.sports_performance.Model.*;

import com.example.sports_performance.Repository.AthleteRepository;
import com.example.sports_performance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService{

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private UserRepository userRepository;

    public Athlete createProfile(AthleteRequestDto athleteRequestDto, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getRole().equals(Role.ATHLETE)) {
            throw new RuntimeException("Only users with ATHLETE role can create a profile");
        }

        Athlete athlete = new Athlete();
        athlete.setUser(user);
        athlete.setFirstname(athleteRequestDto.getFirstname());
        athlete.setLastname(athleteRequestDto.getLastname());
        athlete.setBirthDate(athleteRequestDto.getBirthDate());
        athlete.setGender(athleteRequestDto.getGender());
        athlete.setHeight(athleteRequestDto.getHeight());
        athlete.setWeight(athleteRequestDto.getWeight());
        athlete.setCategory(athleteRequestDto.getCategory());

        return athleteRepository.save(athlete);
    }

    public Athlete getAthlete(String username) {
        return athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
    }

    public Athlete getAthleteById(Long athleteId) {
        return athleteRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete updateAthleteProfile(AthleteRequestDto athleteRequestDto, String username) {
        Athlete athlete = athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));

        athlete.setFirstname(athleteRequestDto.getFirstname());
        athlete.setLastname(athleteRequestDto.getLastname());
        athlete.setBirthDate(athleteRequestDto.getBirthDate());
        athlete.setGender(athleteRequestDto.getGender());
        athlete.setHeight(athleteRequestDto.getHeight());
        athlete.setWeight(athleteRequestDto.getWeight());
        athlete.setCategory(athleteRequestDto.getCategory());

        return athleteRepository.save(athlete);
    }
}
