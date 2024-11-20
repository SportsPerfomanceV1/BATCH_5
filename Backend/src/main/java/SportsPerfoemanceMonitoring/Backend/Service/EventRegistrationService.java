package SportsPerfoemanceMonitoring.Backend.Service;

import SportsPerfoemanceMonitoring.Backend.Dto.EventRegistrationDto;
import SportsPerfoemanceMonitoring.Backend.Model.Athlete;
import SportsPerfoemanceMonitoring.Backend.Model.Event;
import SportsPerfoemanceMonitoring.Backend.Model.EventRegistration;
import SportsPerfoemanceMonitoring.Backend.Repository.AthleteRepository;
import SportsPerfoemanceMonitoring.Backend.Repository.EventRepository;
import SportsPerfoemanceMonitoring.Backend.Repository.EventRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventRegistrationService {
    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private EventRepository eventRepository;

    public EventRegistration registerForEvent(EventRegistrationDto registrationDto) {
        Athlete athlete = athleteRepository.findById(registrationDto.getAthleteId())
                .orElseThrow(() -> new IllegalArgumentException("Athlete not found"));
        Event event = eventRepository.findById(registrationDto.getEventId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        EventRegistration registration = new EventRegistration();
        registration.setAthlete(athlete);
        registration.setEvent(event);
        registration.setRegistrationDate(LocalDateTime.now());
        registration.setStatus(registrationDto.getStatus());

        return eventRegistrationRepository.save(registration);
    }
}