package SpringInfo.ProjectDemo.EventResultApp.Dto;

import lombok.Data;

@Data

public class EventRequest {
    private Long eventId;
    // Getter and setter for eventId
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
