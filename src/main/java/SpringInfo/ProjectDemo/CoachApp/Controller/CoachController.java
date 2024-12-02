package SpringInfo.ProjectDemo.CoachApp.Controller;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachLoginDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachProfileDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachRegistrationDto;
import SpringInfo.ProjectDemo.Util.AuthenticationResponse;
import SpringInfo.ProjectDemo.CoachApp.Service.CoachUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private CoachUserService userService;

    // Register coach endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerCoach(@RequestBody CoachRegistrationDto registrationDTO) {
        userService.registerCoach(registrationDTO);
        return ResponseEntity.ok("Coach registered successfully");
    }

    // Authenticate coach endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody CoachLoginDto loginDTO) throws Exception {
        String jwt = userService.authenticateCoach(loginDTO);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    // Create coach profile endpoint
    @PostMapping("/profile")
    public ResponseEntity<CoachProfileDto> createProfile(@RequestBody CoachProfileDto profileDTO, Principal principal) {
        CoachProfileDto updatedProfile = userService.createCoachProfile(profileDTO, principal.getName());
        return ResponseEntity.ok(updatedProfile);
    }

    // Update coach profile endpoint
    @PutMapping("/profile")
    public ResponseEntity<CoachProfileDto> updateProfile(@RequestBody CoachProfileDto profileDTO, Principal principal) {
        CoachProfileDto updatedProfile = userService.updateCoachProfile(profileDTO, principal.getName());
        return ResponseEntity.ok(updatedProfile);
    }
}
