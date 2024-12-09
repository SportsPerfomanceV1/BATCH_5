package SpringInfo.ProjectDemo.RegistrationApp.Service;

import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;

import SpringInfo.ProjectDemo.AthleteApp.Repository.AthleteRepository;
import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.EventApp.Repository.EventRepository;
import SpringInfo.ProjectDemo.RegistrationApp.Model.Registration;
import SpringInfo.ProjectDemo.RegistrationApp.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class RegistrationService {
    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    public String registerAthleteForEvent(Long athleteId, Long eventId) {
        Athlete athlete = athleteRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Check if already registered
        registrationRepository.findByAthleteAndEvent(athlete, event)
                .ifPresent(registration -> {
                    throw new RuntimeException("Athlete is already registered for this event");
                });

        Registration registration = new Registration();
        registration.setAthlete(athlete);
        registration.setEvent(event);
        registration.setRegistrationDate(LocalDateTime.now()); // Current timestamp
        registration.setStatus("Registered"); // Initial status

        registrationRepository.save(registration);

        return "Athlete successfully registered for the event";
    }
    public List<Event> getRegisteredEventsForAthlete(Long athleteId) {
        Athlete athlete = athleteRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));

        List<Registration> registrations = registrationRepository.findByAthlete(athlete);

        // Map registrations to events
        List<Event> events = new ArrayList<>();
        for (Registration registration : registrations) {
            events.add(registration.getEvent());
        }
        return events;
    }
    //Approve Registration
    public String approveRegistration(Long registrationId) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        // Only approve if the status is "Pending"
        if (registration.getStatus().equals("Pending")) {
            registration.setStatus("Approved");
            registrationRepository.save(registration);
            return "Registration approved successfully!";
        }
        return "Registration is already approved or rejected.";
    }

    // Reject Registration
    public String rejectRegistration(Long registrationId) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        // Only reject if the status is "Pending"
        if (registration.getStatus().equals("Pending")) {
            registration.setStatus("Rejected");
            registrationRepository.save(registration);
            return "Registration rejected successfully!";
        }
        return "Registration is already approved or rejected.";
    }
}
