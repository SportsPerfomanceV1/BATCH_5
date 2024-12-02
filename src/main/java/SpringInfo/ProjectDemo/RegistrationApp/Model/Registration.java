package SpringInfo.ProjectDemo.RegistrationApp.Model;

import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;
import SpringInfo.ProjectDemo.EventApp.Model.Event;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "registrations")

public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event; // Foreign Key to Event table

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete; // Foreign Key to Athlete table

    private LocalDateTime registrationDate; // When the registration was done

    private String status = "Pending"; // e.g., "Registered", "Cancelled"

    // Getters and Setters

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
