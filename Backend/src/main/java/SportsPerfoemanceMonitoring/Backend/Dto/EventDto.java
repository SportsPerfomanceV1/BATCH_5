package SportsPerfoemanceMonitoring.Backend.Dto;

import lombok.Data;

@Data
public class EventDto {
    private Long eventId;
    private String eventName;
    private String category;
    private String location;
}