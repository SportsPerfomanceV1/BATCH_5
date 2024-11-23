package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.CoachRequestDto;
import com.example.sports_performance.Model.Coach;
import com.example.sports_performance.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/profile")
    public ResponseEntity<Coach> createProfile(@RequestBody CoachRequestDto coachRequestDto, @RequestParam String username) {
        return ResponseEntity.ok(coachService.createProfile(coachRequestDto, username));
    }

    @PutMapping("/profile")
    public ResponseEntity<Coach> editProfile(@RequestBody CoachRequestDto coachRequestDto, @RequestParam String username) {
        return ResponseEntity.ok(coachService.editProfile(coachRequestDto, username));
    }

    @GetMapping("/profile")
    public ResponseEntity<Coach> getProfile(@RequestParam String username) {
        return ResponseEntity.ok(coachService.getProfile(username));
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        return ResponseEntity.ok(coachService.getAllCoaches());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Coach>> searchCoaches(@RequestParam(required = false) String name,
                                                     @RequestParam(required = false) String category) {
        if (name != null) {
            return ResponseEntity.ok(coachService.searchCoachesByName(name));
        }
        if (category != null) {
            return ResponseEntity.ok(coachService.searchCoachesByCategory(category));
        }
        return ResponseEntity.badRequest().build();
    }
}
