package SpringInfo.ProjectDemo.AdminApp.Controller;

import SpringInfo.ProjectDemo.AdminApp.Dto.AdminLoginDto;
import SpringInfo.ProjectDemo.AdminApp.Dto.AdminRegistrationDto;
import SpringInfo.ProjectDemo.AdminApp.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")

public class AdminUserController {
    @Autowired

    private AdminUserService adminUserService;

    // Register a new Admin
    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegistrationDto registrationDTO) {
        adminUserService.registerAdmin(registrationDTO);
        return ResponseEntity.ok("Admin registered successfully");
    }

    // Admin login (Authentication)
    @PostMapping("/login")
    public ResponseEntity<String> authenticateAdmin(@RequestBody AdminLoginDto loginDTO) throws Exception {
        String token = adminUserService.authenticateAdmin(loginDTO);
        return ResponseEntity.ok(token);  // Return JWT token
    }
}
