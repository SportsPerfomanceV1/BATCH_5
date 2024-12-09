package SpringInfo.ProjectDemo.EventApp.Controller;
import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.EventApp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/eventscreation")

public class EventController {



        @Autowired
        private EventService eventService;

        // Fetch all events
        @GetMapping
        public ResponseEntity<List<Event>> getAvailableEvents() {
            List<Event> events = eventService.getAvailableEvents();
            return new ResponseEntity<>(events, HttpStatus.OK);
        }

    @PreAuthorize("hasAnyRole('ADMIN', 'COACH')")
    @PostMapping("/create")

        // Create a new event

        public ResponseEntity<Event> createEvent(@RequestBody Event event) {
            Event newEvent = eventService.createEvent(event);
            return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
        }

        // Update an event    // Only ADMIN and COACH can update an event
           @PreAuthorize("hasAnyRole('ADMIN', 'COACH')")
           @PutMapping("/{eventId}")

        public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
            try {
                Event event = eventService.updateEvent(eventId, updatedEvent);
                return new ResponseEntity<>(event, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        // Delete an event
        @DeleteMapping("/{eventId}")
        public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long eventId) {
            try {
                eventService.deleteEvent(eventId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }


