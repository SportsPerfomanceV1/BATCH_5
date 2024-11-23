package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.AchievementDto;
import com.example.sports_performance.Model.Achievement;
import com.example.sports_performance.Service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    // Create an achievement for a coach
    @PostMapping("/")
    public ResponseEntity<Achievement> createAchievement(@RequestBody AchievementDto achievementDto,
                                                         @RequestParam Long coachId) {
        return ResponseEntity.ok(achievementService.createAchievement(achievementDto, coachId));
    }

    // Get all achievements of a coach
    @GetMapping("/coach/{coachId}")
    public ResponseEntity<List<Achievement>> getAchievementsByCoach(@PathVariable Long coachId) {
        return ResponseEntity.ok(achievementService.getAchievementsByCoach(coachId));
    }

    // Get achievement by its ID
    @GetMapping("/{achievementId}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable Long achievementId) {
        return ResponseEntity.ok(achievementService.getAchievementById(achievementId));
    }
}
