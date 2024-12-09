package SpringInfo.ProjectDemo.EventApp.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data

public class EventCreateDto {
    private String name;
    private String meetName;
    private String description;
    private String category;
    private LocalDate eventDate;
    private String location;
}
