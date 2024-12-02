package SpringInfo.ProjectDemo.EventResultApp.Repository;

import SpringInfo.ProjectDemo.EventResultApp.Model.EventResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventResultRepository extends JpaRepository <EventResult , Long> {
    List<EventResult> findAllByEventId(Long eventId);
}
