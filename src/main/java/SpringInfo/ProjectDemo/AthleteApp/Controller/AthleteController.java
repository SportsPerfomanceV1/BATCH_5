package SpringInfo.ProjectDemo.AthleteApp.Controller;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteLoginDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteProfileDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteRegistrationDto;
import SpringInfo.ProjectDemo.EventApp.Service.EventService;
import SpringInfo.ProjectDemo.Util.AuthenticationResponse;
import SpringInfo.ProjectDemo.AthleteApp.Service.AthleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {

    @Autowired
    private AthleteUserService userService;

    @Autowired
    private EventService eventService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AthleteRegistrationDto registrationDTO) {
        userService.registerAthlete(registrationDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AthleteLoginDto loginDTO) throws Exception {
        String jwt = userService.authenticateAthlete(loginDTO);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
    @PostMapping("/profile")
    public ResponseEntity<AthleteProfileDto> createProfile(@RequestBody AthleteProfileDto profileDTO, Principal principal) {
        AthleteProfileDto updatedProfile = userService.createAthleteProfile(profileDTO, principal.getName());
        return ResponseEntity.ok(updatedProfile);
    }
    @PutMapping("/profile")
    public ResponseEntity<AthleteProfileDto> updateProfile(@RequestBody AthleteProfileDto profileDTO, Principal principal) {
        AthleteProfileDto updatedProfile = userService.updateAthleteProfile(profileDTO, principal.getName());
        return ResponseEntity.ok(updatedProfile);
    }

}