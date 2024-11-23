package com.example.sports_performance.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    private String title;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date achievedDate;

    // Getters and Setters
    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

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
