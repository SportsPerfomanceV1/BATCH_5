package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.AchievementDto;
import com.example.sports_performance.Model.Achievement;
import com.example.sports_performance.Model.Coach;
import com.example.sports_performance.Repository.AchievementRepository;
import com.example.sports_performance.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService{

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private CoachRepository coachRepository;

    public Achievement createAchievement(AchievementDto achievementDto, Long coachId) {
        Coach coach = coachRepository.findById(coachId)
                .orElseThrow(() -> new RuntimeException("Coach not found"));

        Achievement achievement = new Achievement();
        achievement.setCoach(coach);
        achievement.setTitle(achievementDto.getTitle());
        achievement.setDescription(achievementDto.getDescription());
        achievement.setAchievedDate(achievementDto.getAchievedDate());

        return achievementRepository.save(achievement);
    }

    public List<Achievement> getAchievementsByCoach(Long coachId) {
        return achievementRepository.findByCoach_CoachId(coachId);
    }

    public Achievement getAchievementById(Long achievementId) {
        return achievementRepository.findById(achievementId)
                .orElseThrow(() -> new RuntimeException("Achievement not found"));
    }
}

