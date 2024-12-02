package SpringInfo.ProjectDemo.RegistrationApp.Repository;

import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;
import SpringInfo.ProjectDemo.EventApp.Model.Event;
import SpringInfo.ProjectDemo.RegistrationApp.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Optional<Registration> findByAthleteAndEvent(Athlete athlete, Event event);
    List<Registration> findByAthlete(Athlete athlete);
    boolean existsByAthleteAndEvent(Athlete athlete, Event event);
}
