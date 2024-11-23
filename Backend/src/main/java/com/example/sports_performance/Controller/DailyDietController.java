package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.DailyDietRequestDto;
import com.example.sports_performance.Model.DailyDiet;
import com.example.sports_performance.Service.DailyDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-diets")
public class DailyDietController {

    @Autowired
    private DailyDietService dailyDietService;

    @PostMapping
    public ResponseEntity<DailyDiet> logDailyDiet(@RequestBody DailyDietRequestDto dailyDietRequestDto,
                                                  @RequestParam String username) {
        return ResponseEntity.ok(dailyDietService.logDailyDiet(dailyDietRequestDto, username));
    }

    @GetMapping
    public ResponseEntity<List<DailyDiet>> getDailyDietLogs(@RequestParam String username) {
        return ResponseEntity.ok(dailyDietService.getDailyDietLogs(username));
    }
}
