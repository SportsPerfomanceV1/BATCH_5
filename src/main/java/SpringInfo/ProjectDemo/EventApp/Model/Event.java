package SpringInfo.ProjectDemo.EventApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Events")

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String meetName;
    private String description;
    private String Category;





    private LocalDate eventDate;
    private String location;


}
