package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.AthleteRequestDto;
import com.example.sports_performance.Model.Athlete;
import com.example.sports_performance.Service.AthleteService;
import com.example.sports_performance.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/profile")
    public ResponseEntity<String> createAthleteProfile(@RequestBody AthleteRequestDto athleteRequestDto,
                                                        @RequestHeader("Authorization") String token) {
        String username = jwtUtil.getUsernameFromToken(token.replace("Bearer ", ""));
        Athlete athlete = athleteService.createProfile(athleteRequestDto, username);
        return ResponseEntity.ok("Profile created successfully!");
    }

    @GetMapping("/{athleteId}")
    public ResponseEntity<Athlete> getAthlete(@PathVariable Long athleteId) {
        return ResponseEntity.ok(athleteService.getAthleteById(athleteId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Athlete> getAthleteByUsername(@PathVariable String username) {
        return ResponseEntity.ok(athleteService.getAthlete(username));
    }

    @GetMapping("/")
    public ResponseEntity<List<Athlete>> getAllAthletes() {
        return ResponseEntity.ok(athleteService.getAllAthletes());
    }

    @PutMapping("/profile")
    public ResponseEntity<Athlete> updateAthleteProfile(@RequestBody AthleteRequestDto athleteRequestDto,
                                                        @RequestParam String username) {
        return ResponseEntity.ok(athleteService.updateAthleteProfile(athleteRequestDto, username));
    }
}