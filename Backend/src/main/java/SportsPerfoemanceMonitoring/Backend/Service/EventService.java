package SportsPerfoemanceMonitoring.Backend.Service;

import SportsPerfoemanceMonitoring.Backend.Model.Event;
import SportsPerfoemanceMonitoring.Backend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event findEventByName(String eventName) {
        Optional<Event> event = eventRepository.findByEventName(eventName);
        return event.orElseThrow(() -> new IllegalArgumentException("Event not found with name: " + eventName));
    }
}