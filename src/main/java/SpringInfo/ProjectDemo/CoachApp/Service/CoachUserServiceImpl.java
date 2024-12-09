package SpringInfo.ProjectDemo.CoachApp.Service;

import SpringInfo.ProjectDemo.CoachApp.Dto.CoachLoginDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachProfileDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachRegistrationDto;
import SpringInfo.ProjectDemo.CoachApp.Model.Coach;
import SpringInfo.ProjectDemo.CoachApp.Repository.CoachRepository;
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

public class CoachUserServiceImpl implements CoachUserService {

    @Autowired
    private CoachRepository coachRepository ;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public void registerCoach(CoachRegistrationDto registrationDTO) {
        Coach coach = new Coach();
        coach.setUsername(registrationDTO.getUsername());
        coach.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        coach.setEmail(registrationDTO.getEmail());
        coach.setFullName(registrationDTO.getFullName());
        coachRepository.save(coach);
    }
    @Override
    public CoachProfileDto createCoachProfile(CoachProfileDto profileDTO, String username) {
        Coach coach = coachRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Coach not found"));
        coach.setEmail(profileDTO.getEmail());
        coach.setFullName(profileDTO.getFullName());
        coach.setGender(profileDTO.getGender());
        coach.setBirthdate(profileDTO.getBirthdate());
        coach.setCategory(profileDTO.getCategory());
        coach.setPhotoUrl(profileDTO.getPhotoUrl());
        coach.setBio(profileDTO.getBio());
        coachRepository.save(coach);
        return profileDTO;
    }
    @Override
    public CoachProfileDto updateCoachProfile(CoachProfileDto profileDTO, String username) {
        Coach coach = coachRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Coach not found"));

        coach.setEmail(profileDTO.getEmail());
        coach.setFullName(profileDTO.getFullName());
        coach.setGender(profileDTO.getGender());
        coach.setBirthdate(profileDTO.getBirthdate());
        coach.setCategory(profileDTO.getCategory());
        coach.setPhotoUrl(profileDTO.getPhotoUrl());
        coach.setBio(profileDTO.getBio());

        coachRepository.save(coach);
        return profileDTO;
    }
    @Override
    public String authenticateCoach(CoachLoginDto loginDTO) throws Exception {
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
