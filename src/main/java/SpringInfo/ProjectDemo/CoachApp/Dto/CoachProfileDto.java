package SpringInfo.ProjectDemo.CoachApp.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data

public class CoachProfileDto {
    private String email;
    private String fullName;
    private String gender;
    private LocalDate birthdate;
    private String category;
    private String photoUrl;
    private String bio;
}
