package com.example.sports_performance.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assistance_requests")
public class AssistanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assistanceRequestId;

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    @Column(nullable = false)
    private String status; // e.g., PENDING, APPROVED, REJECTED

    private String remarks;

    @Column(nullable = false)
    private LocalDate requestDate;

    // Getters and Setters
    public Long getAssistanceRequestId() {
        return assistanceRequestId;
    }

    public void setAssistanceRequestId(Long assistanceRequestId) {
        this.assistanceRequestId = assistanceRequestId;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
