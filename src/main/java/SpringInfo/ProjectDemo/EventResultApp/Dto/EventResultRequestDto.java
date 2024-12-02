package SpringInfo.ProjectDemo.EventResultApp.Dto;

import lombok.Data;

@Data

public class EventResultRequestDto {
    private Long athleteId;
    private Long eventId;
    private Double score;
    private String remarks;
}
