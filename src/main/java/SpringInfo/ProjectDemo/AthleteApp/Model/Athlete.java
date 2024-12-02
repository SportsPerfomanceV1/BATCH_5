package SpringInfo.ProjectDemo.AthleteApp.Model;

import SpringInfo.ProjectDemo.Service.Role;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name= "Athlete")

public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String bio;
    private String gender;
    private LocalDate birthdate;
    private Double height;
    private Double weight;
    private String category;
    private Long coachId;
    private String photoUrl;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ATHLETE;
}
