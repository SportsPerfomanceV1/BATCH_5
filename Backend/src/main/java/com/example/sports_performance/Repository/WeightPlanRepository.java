package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.WeightPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightPlanRepository extends JpaRepository<WeightPlan, Long> {
    Optional<WeightPlan> findByAthlete_AthleteId(Long athleteId);
}
