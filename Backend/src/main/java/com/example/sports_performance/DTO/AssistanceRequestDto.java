package com.example.sports_performance.DTO;

public class AssistanceRequestDto {

    private Long coachId;
    private String remarks;

    // Getters and Setters
    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
