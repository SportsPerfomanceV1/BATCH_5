package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.WeightPlanRequestDto;
import com.example.sports_performance.Model.Athlete;
import com.example.sports_performance.Model.WeightPlan;
import com.example.sports_performance.Repository.AthleteRepository;
import com.example.sports_performance.Repository.WeightPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeightPlanService{

    @Autowired
    private WeightPlanRepository weightPlanRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    public WeightPlan createWeightPlan(WeightPlanRequestDto weightPlanRequestDto, String username) {
        Athlete athlete = athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Athlete not found."));

        if (weightPlanRepository.findByAthlete_AthleteId(athlete.getAthleteId()).isPresent()) {
            throw new IllegalArgumentException("Weight plan already exists for this athlete.");
        }

        WeightPlan weightPlan = new WeightPlan();
        weightPlan.setAthlete(athlete);
        weightPlan.setStartWeight(weightPlanRequestDto.getStartWeight());
        weightPlan.setTargetWeight(weightPlanRequestDto.getTargetWeight());
        weightPlan.setPreference(weightPlanRequestDto.getPreference());
        weightPlan.setDailyCalorieGoal(weightPlanRequestDto.getDailyCalorieGoal());

        return weightPlanRepository.save(weightPlan);
    }

    public WeightPlan getWeightPlan(String username) {
        Athlete athlete = athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Athlete not found."));

        return weightPlanRepository.findByAthlete_AthleteId(athlete.getAthleteId())
                .orElseThrow(() -> new IllegalArgumentException("Weight plan not found."));
    }

    public WeightPlan updateWeightPlan(Long id, WeightPlanRequestDto weightPlanRequestDto, String username) {
        WeightPlan weightPlan = weightPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Weight plan not found."));

        weightPlan.setStartWeight(weightPlanRequestDto.getStartWeight());
        weightPlan.setTargetWeight(weightPlanRequestDto.getTargetWeight());
        weightPlan.setPreference(weightPlanRequestDto.getPreference());
        weightPlan.setDailyCalorieGoal(weightPlanRequestDto.getDailyCalorieGoal());

        return weightPlanRepository.save(weightPlan);
    }
}

