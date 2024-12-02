package SpringInfo.ProjectDemo.AthleteApp.Service;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteLoginDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteProfileDto;
import SpringInfo.ProjectDemo.AthleteApp.Dto.AthleteRegistrationDto;
import org.springframework.stereotype.Service;

@Service

public interface AthleteUserService {
    void registerAthlete(AthleteRegistrationDto registrationDTO);

    AthleteProfileDto createAthleteProfile(AthleteProfileDto profileDTO, String username);
    AthleteProfileDto updateAthleteProfile(AthleteProfileDto profileDTO, String username);
    String authenticateAthlete(AthleteLoginDto loginDTO) throws Exception;
}
