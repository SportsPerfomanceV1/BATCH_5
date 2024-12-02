package SpringInfo.ProjectDemo.AdminApp.Controller;

import SpringInfo.ProjectDemo.RegistrationApp.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")

public class AdminRegistrationController {
    @Autowired
    private RegistrationService registrationService;

    // Approve a registration


    @PutMapping("/{registrationId}/approve")
    public ResponseEntity<String> approveRegistration(@PathVariable Long registrationId) {
        String response = registrationService.approveRegistration(registrationId);
        return ResponseEntity.ok(response);
    }

    // Reject a registration

    @PutMapping("/{registrationId}/reject")
    public ResponseEntity<String> rejectRegistration(@PathVariable Long registrationId) {
        String response = registrationService.rejectRegistration(registrationId);
        return ResponseEntity.ok(response);
    }
}
