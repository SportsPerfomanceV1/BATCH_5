package com.example.sports_performance.Repository;

import com.example.sports_performance.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByUserId(Long userId);
    List<Coach> findByCategoryContainingIgnoreCase(String category);
    List<Coach> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}
