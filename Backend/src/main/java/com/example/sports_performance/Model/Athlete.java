package com.example.sports_performance.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "athletes")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athleteId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "weight_plan_id")
    private WeightPlan weightPlan;

    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String gender;
    private double height;
    private double weight;
    private String category;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToMany(mappedBy = "athlete")
    private List<DailyDiet> dailyDiets;

    @OneToMany(mappedBy = "athlete")
    private List<AssistanceRequest> assistanceRequests;

    // Getters and Setters
    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WeightPlan getWeightPlan() {
        return weightPlan;
    }

    public void setWeightPlan(WeightPlan weightPlan) {
        this.weightPlan = weightPlan;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<DailyDiet> getDailyDiets() {
        return dailyDiets;
    }

    public void setDailyDiets(List<DailyDiet> dailyDiets) {
        this.dailyDiets = dailyDiets;
    }

    public List<AssistanceRequest> getAssistanceRequests() {
        return assistanceRequests;
    }

    public void setAssistanceRequests(List<AssistanceRequest> assistanceRequests) {
        this.assistanceRequests = assistanceRequests;
    }
}