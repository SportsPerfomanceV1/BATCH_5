package SpringInfo.ProjectDemo.AthleteApp.Repository;

import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Optional<Athlete> findByUsername(String username);
}