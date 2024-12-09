package SpringInfo.ProjectDemo.CoachApp.Service;

import SpringInfo.ProjectDemo.CoachApp.Dto.CoachLoginDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachProfileDto;
import SpringInfo.ProjectDemo.CoachApp.Dto.CoachRegistrationDto;
import org.springframework.stereotype.Service;

@Service

public interface CoachUserService {
    void registerCoach(CoachRegistrationDto registrationDTO);

    CoachProfileDto createCoachProfile(CoachProfileDto profileDto, String username);
    CoachProfileDto updateCoachProfile(CoachProfileDto profileDto, String username);
    String authenticateCoach(CoachLoginDto loginDTO) throws Exception;
}
