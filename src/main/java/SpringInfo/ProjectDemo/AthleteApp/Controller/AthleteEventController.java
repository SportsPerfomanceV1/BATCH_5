package SpringInfo.ProjectDemo.AthleteApp.Controller;

import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.EventApp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/athlete")

public class AthleteEventController {
    @Autowired
    private EventService eventService;
    // Endpoint to fetch all available events
    @GetMapping("/events/available")
    public ResponseEntity<List<Event>> getAvailableEvents() {
        List<Event> events = eventService.getAvailableEvents();
        return ResponseEntity.ok(events);
    }
}
