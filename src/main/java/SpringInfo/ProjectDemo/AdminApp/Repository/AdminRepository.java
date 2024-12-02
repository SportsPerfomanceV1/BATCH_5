package SpringInfo.ProjectDemo.AdminApp.Repository;

import SpringInfo.ProjectDemo.AdminApp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}