package SpringInfo.ProjectDemo.EventApp.Service;

import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.EventApp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EventService {
    @Autowired
    private EventRepository eventRepository;

    // Method to fetch all available events

    public List<Event> getAvailableEvents() {
        return eventRepository.findAll();
    }
    // Create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Update an existing event
    public Event updateEvent(Long eventId, Event updatedEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found."));
        event.setName(updatedEvent.getName());
        event.setMeetName(updatedEvent.getMeetName());
        event.setDescription(updatedEvent.getDescription());
        event.setCategory(updatedEvent.getCategory());
        event.setEventDate(updatedEvent.getEventDate());
        event.setLocation(updatedEvent.getLocation());
        return eventRepository.save(event);
    }

    // Delete an event
    public void deleteEvent(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new RuntimeException("Event not found.");
        }
        eventRepository.deleteById(eventId);
    }
}
