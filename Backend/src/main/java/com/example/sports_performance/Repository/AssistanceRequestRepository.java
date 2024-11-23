package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.AssistanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssistanceRequestRepository extends JpaRepository<AssistanceRequest, Long> {
    List<AssistanceRequest> findByCoach_CoachId(Long coachId);
    List<AssistanceRequest> findByAthlete_AthleteId(Long athleteId);
}
