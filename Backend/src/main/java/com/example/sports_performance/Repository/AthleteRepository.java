package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Optional<Athlete> findByUserId(Long userId);
    Optional<Athlete> findByUserUsername(String username);
}
