package com.example.sports_performance.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "weight_plans")
public class WeightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id")  // This column will store the reference to Athlete
    private Athlete athlete;

    @Column(nullable = false)
    private double startWeight;

    @Column(nullable = false)
    private double targetWeight;

    @Column(nullable = false)
    private String preference; // e.g., Vegetarian, Non-Vegetarian

    @Column(nullable = false)
    private double dailyCalorieGoal;

    @OneToMany(mappedBy = "weightPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyDiet> dailyDiets;

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

    public double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(double startWeight) {
        this.startWeight = startWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public double getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(double dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public List<DailyDiet> getDailyDiets() {
        return dailyDiets;
    }

    public void setDailyDiets(List<DailyDiet> dailyDiets) {
        this.dailyDiets = dailyDiets;
    }
}
