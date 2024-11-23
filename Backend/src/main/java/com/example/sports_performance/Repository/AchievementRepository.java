package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findByCoach_CoachId(Long coachId); // Find achievements by coach
}

