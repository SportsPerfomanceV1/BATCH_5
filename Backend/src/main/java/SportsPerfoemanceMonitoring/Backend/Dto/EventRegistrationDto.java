package SportsPerfoemanceMonitoring.Backend.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class EventRegistrationDto {
    private Long athleteId;
    private Long eventId;
    private Date registrationDate;
    private String status;
}