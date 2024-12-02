package SpringInfo.ProjectDemo.CoachApp.Model;

import SpringInfo.ProjectDemo.Service.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "coach")

public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String gender;
    private String bio;
    private LocalDate birthdate;
    private String category;
    private String photoUrl;
    @Enumerated(EnumType.STRING)
    private Role role = Role.COACH; // Default role
}