package SpringInfo.ProjectDemo.AthleteApp.Service;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteLoginDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteProfileDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteRegistrationDto;
import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;
import SpringInfo.ProjectDemo.AthleteApp.Repository.AthleteRepository;
import SpringInfo.ProjectDemo.Service.CustomUserDetailsService;
import SpringInfo.ProjectDemo.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AthleteUserServiceImpl implements AthleteUserService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void registerAthlete(AthleteRegistrationDto registrationDTO) {
        Athlete athlete = new Athlete();
        athlete.setUsername(registrationDTO.getUsername());
        athlete.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        athlete.setEmail(registrationDTO.getEmail());
        athlete.setFullName(registrationDTO.getFullName());
        athleteRepository.save(athlete);
    }

    @Override
    public AthleteProfileDto createAthleteProfile(AthleteProfileDto profileDTO, String username) {
        Athlete athlete = athleteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        athlete.setEmail(profileDTO.getEmail());
        athlete.setFullName(profileDTO.getFullName());
        athlete.setGender(profileDTO.getGender());
        athlete.setBirthdate(profileDTO.getBirthdate());
        athlete.setHeight(profileDTO.getHeight());
        athlete.setWeight(profileDTO.getWeight());
        athlete.setCategory(profileDTO.getCategory());
        athlete.setCoachId(profileDTO.getCoachId());
        athlete.setPhotoUrl(profileDTO.getPhotoUrl());
        athlete.setBio(profileDTO.getBio());
        athleteRepository.save(athlete);
        return profileDTO;
    }

    @Override
    public AthleteProfileDto updateAthleteProfile(AthleteProfileDto profileDTO, String username) {
        Athlete athlete = athleteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        athlete.setEmail(profileDTO.getEmail());
        athlete.setFullName(profileDTO.getFullName());
        athlete.setGender(profileDTO.getGender());
        athlete.setBirthdate(profileDTO.getBirthdate());
        athlete.setHeight(profileDTO.getHeight());
        athlete.setWeight(profileDTO.getWeight());
        athlete.setCategory(profileDTO.getCategory());
        athlete.setCoachId(profileDTO.getCoachId());
        athlete.setPhotoUrl(profileDTO.getPhotoUrl());
        athlete.setBio(profileDTO.getBio());
        athleteRepository.save(athlete);
        return profileDTO;
    }

    @Override
    public String authenticateAthlete(AthleteLoginDto loginDTO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}