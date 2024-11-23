package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.DailyDietRequestDto;
import com.example.sports_performance.Model.Athlete;
import com.example.sports_performance.Model.DailyDiet;
import com.example.sports_performance.Repository.AthleteRepository;
import com.example.sports_performance.Repository.DailyDietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyDietService{

    @Autowired
    private DailyDietRepository dailyDietRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    public DailyDiet logDailyDiet(DailyDietRequestDto dailyDietRequestDto, String username) {
        Athlete athlete = athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Athlete not found."));

        DailyDiet dailyDiet = new DailyDiet();
        dailyDiet.setAthlete(athlete);
        dailyDiet.setWeightPlan(athlete.getWeightPlan()); // Ensure this is set up in Athlete
        dailyDiet.setDate(dailyDietRequestDto.getDate());
        dailyDiet.setCalories(dailyDietRequestDto.getCalories());
        dailyDiet.setCurrentWeight(dailyDietRequestDto.getCurrentWeight());

        return dailyDietRepository.save(dailyDiet);
    }

    public List<DailyDiet> getDailyDietLogs(String username) {
        Athlete athlete = athleteRepository.findByUserUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Athlete not found."));

        return dailyDietRepository.findByAthleteAthleteId(athlete.getAthleteId());
    }
}
