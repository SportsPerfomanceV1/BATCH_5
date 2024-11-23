package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.DailyDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyDietRepository extends JpaRepository<DailyDiet, Long> {
    List<DailyDiet> findByAthleteAthleteId(Long athleteId);
}
