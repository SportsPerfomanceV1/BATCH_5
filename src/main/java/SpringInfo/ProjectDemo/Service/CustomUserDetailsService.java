package SpringInfo.ProjectDemo.Service;

import SpringInfo.ProjectDemo.AdminApp.Model.Admin;
import SpringInfo.ProjectDemo.AthleteApp.Model.Athlete;
import SpringInfo.ProjectDemo.AthleteApp.Repository.AthleteRepository;
import SpringInfo.ProjectDemo.CoachApp.Repository.CoachRepository;
import SpringInfo.ProjectDemo.AdminApp.Repository.AdminRepository;

import SpringInfo.ProjectDemo.CoachApp.Model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AthleteRepository athleteRepository;
    @Autowired
    private CoachRepository coachRepository;

    @Autowired AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Athlete athlete = athleteRepository.findByUsername(username).orElse(null);
        if (athlete != null) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ATHLETE")); // Add athlete role
            return new User(athlete.getUsername(), athlete.getPassword(), authorities);
        }

        Coach coach = coachRepository.findByUsername(username).orElse(null);
        if (coach != null) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_COACH")); // Add coach role
            return new User(coach.getUsername(), coach.getPassword(), authorities);
        }
        Admin admin = adminRepository.findByUsername(username).orElse(null);
        if (admin != null) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(admin.getUsername(), admin.getPassword(), authorities);
        }

        throw new UsernameNotFoundException("User not found");
    }
}