package SportsPerfoemanceMonitoring.Backend.Controller;

import SportsPerfoemanceMonitoring.Backend.Dto.EventRegistrationDto;
import SportsPerfoemanceMonitoring.Backend.Model.EventRegistration;
import SportsPerfoemanceMonitoring.Backend.Service.EventRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event-registration")
public class EventRegistrationController {
    @Autowired
    private EventRegistrationService eventRegistrationService;

    @PostMapping("/register")
    public ResponseEntity registerForEvent(@RequestBody EventRegistrationDto registrationDto) {
        try {
            EventRegistration registration = eventRegistrationService.registerForEvent(registrationDto);
            return ResponseEntity.ok(registration);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}
