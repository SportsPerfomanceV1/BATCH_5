package SpringInfo.ProjectDemo.EventResultApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Results")

@Data

public class EventResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "athlete_id")
    private Long athleteId;

    private Double score;
    private String remarks;
    private LocalDateTime publishDate;
}
