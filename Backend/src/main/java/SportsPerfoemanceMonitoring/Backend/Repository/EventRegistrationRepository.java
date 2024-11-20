package SportsPerfoemanceMonitoring.Backend.Repository;

import SportsPerfoemanceMonitoring.Backend.Model.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {
}