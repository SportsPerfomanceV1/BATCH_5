package SpringInfo.ProjectDemo.AdminApp.Service;
import SpringInfo.ProjectDemo.AdminApp.Dto.AdminLoginDto;
import SpringInfo.ProjectDemo.AdminApp.Dto.AdminRegistrationDto;
import SpringInfo.ProjectDemo.AdminApp.Model.Admin;
import SpringInfo.ProjectDemo.AdminApp.Repository.AdminRepository;
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

public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void registerAdmin(AdminRegistrationDto registrationDTO) {
        Admin admin = new Admin();
        admin.setUsername(registrationDTO.getUsername());
        admin.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        adminRepository.save(admin);
    }

    @Override
    public String authenticateAdmin(AdminLoginDto loginDTO) throws Exception {
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