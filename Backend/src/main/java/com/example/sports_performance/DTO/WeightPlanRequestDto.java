package com.example.sports_performance.DTO;

public class WeightPlanRequestDto {

    private double startWeight;
    private double targetWeight;
    private String preference; // e.g., Vegetarian, Non-Vegetarian
    private double dailyCalorieGoal;

    // Getters and Setters
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
}
