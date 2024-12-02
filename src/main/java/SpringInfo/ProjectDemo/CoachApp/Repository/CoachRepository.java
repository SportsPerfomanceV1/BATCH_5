package SpringInfo.ProjectDemo.CoachApp.Repository;

import SpringInfo.ProjectDemo.CoachApp.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByUsername(String username);
}
