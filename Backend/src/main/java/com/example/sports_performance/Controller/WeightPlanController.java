package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.WeightPlanRequestDto;
import com.example.sports_performance.Model.WeightPlan;
import com.example.sports_performance.Service.WeightPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight-plans")
public class WeightPlanController {

    @Autowired
    private WeightPlanService weightPlanService;

    @PostMapping
    public ResponseEntity<WeightPlan> createWeightPlan(@RequestBody WeightPlanRequestDto weightPlanRequestDto,
                                                       @RequestParam String username) {
        return ResponseEntity.ok(weightPlanService.createWeightPlan(weightPlanRequestDto, username));
    }

    @GetMapping
    public ResponseEntity<WeightPlan> getWeightPlan(@RequestParam String username) {
        return ResponseEntity.ok(weightPlanService.getWeightPlan(username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeightPlan> updateWeightPlan(@PathVariable Long id,
                                                       @RequestBody WeightPlanRequestDto weightPlanRequestDto,
                                                       @RequestParam String username) {
        return ResponseEntity.ok(weightPlanService.updateWeightPlan(id, weightPlanRequestDto, username));
    }
}
