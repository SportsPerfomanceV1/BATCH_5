package SpringInfo.ProjectDemo.EventResultApp.Service;

import SpringInfo.ProjectDemo.AthleteApp.Repository.AthleteRepository;
import SpringInfo.ProjectDemo.EventApp.Repository.EventRepository;
import SpringInfo.ProjectDemo.EventResultApp.Model.EventResult;
import SpringInfo.ProjectDemo.EventResultApp.Repository.EventResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service

public class EventResultService {
    @Autowired
    private EventResultRepository eventResultRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    // Method to upload result for a specific event
    public EventResult publishResult(Long athleteId, Long eventId, Double score, String remarks) {
        // Validate that the event and athlete exist
        eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        athleteRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));

        // Create EventResult object
        EventResult result = new EventResult();
        result.setEventId(eventId);
        result.setAthleteId(athleteId);
        result.setScore(score);
        result.setRemarks(remarks);
        result.setPublishDate(LocalDateTime.now());
     // Initially set as "Published", can be changed later

        return eventResultRepository.save(result);
    }

    // Method to fetch results for an event
    public List<EventResult> getResultsForEvent(Long eventId) {
        return eventResultRepository.findAllByEventId(eventId);
    }
}
