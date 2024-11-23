package com.example.sports_performance.DTO;

import java.util.Date;

public class AchievementDto {

    private String title;
    private String description;
    private Date achievedDate;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAchievedDate() {
        return achievedDate;
    }

    public void setAchievedDate(Date achievedDate) {
        this.achievedDate = achievedDate;
    }
}
