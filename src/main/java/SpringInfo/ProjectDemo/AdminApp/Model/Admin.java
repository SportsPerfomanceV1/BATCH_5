package SpringInfo.ProjectDemo.AdminApp.Model;

import SpringInfo.ProjectDemo.Service.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Role role = Role.ADMIN;
}
