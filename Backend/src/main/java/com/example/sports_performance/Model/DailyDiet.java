package com.example.sports_performance.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_diets")
public class DailyDiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "weight_plan_id", nullable = false)
    private WeightPlan weightPlan;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double calories;

    @Column(nullable = false)
    private double currentWeight;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public WeightPlan getWeightPlan() {
        return weightPlan;
    }

    public void setWeightPlan(WeightPlan weightPlan) {
        this.weightPlan = weightPlan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
