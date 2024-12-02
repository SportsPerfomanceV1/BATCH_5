package SpringInfo.ProjectDemo.AthleteApp.Controller;


import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.RegistrationApp.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("/api/athlete")

public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/{athleteId}/events/{eventId}/register")
    public ResponseEntity<String> registerAthleteForEvent(
            @PathVariable Long athleteId,
            @PathVariable Long eventId) {
        String response = registrationService.registerAthleteForEvent(athleteId, eventId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{athleteId}/registered-events")
    public ResponseEntity<List<Event>> getRegisteredEvents(@PathVariable Long athleteId) {
        List<Event> events = registrationService.getRegisteredEventsForAthlete(athleteId);
        return ResponseEntity.ok(events);
    }
}
