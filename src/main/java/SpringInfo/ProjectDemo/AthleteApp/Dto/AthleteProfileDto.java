package SpringInfo.ProjectDemo.AthleteApp.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class AthleteProfileDto {
    private String email;
    private String fullName;
    private String gender;
    private LocalDate birthdate;
    private Double height;
    private Double weight;
    private String category;
    private Long coachId;
    private String photoUrl;
    private String bio;
}
