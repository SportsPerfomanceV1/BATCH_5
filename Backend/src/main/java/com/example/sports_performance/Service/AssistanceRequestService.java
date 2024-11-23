package com.example.sports_performance.Service;

import com.example.sports_performance.DTO.AssistanceRequestDto;
import com.example.sports_performance.Model.*;
import com.example.sports_performance.Repository.AssistanceRequestRepository;
import com.example.sports_performance.Repository.AthleteRepository;
import com.example.sports_performance.Repository.CoachRepository;
import com.example.sports_performance.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssistanceRequestService{

    @Autowired
    private AssistanceRequestRepository assistanceRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private CoachRepository coachRepository;

    public AssistanceRequest createRequest(AssistanceRequestDto requestDto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        Athlete athlete = athleteRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Athlete profile not found."));
        Coach coach = coachRepository.findById(requestDto.getCoachId())
                .orElseThrow(() -> new IllegalArgumentException("Coach not found."));

        AssistanceRequest request = new AssistanceRequest();
        request.setAthlete(athlete);
        request.setCoach(coach);
        request.setStatus("PENDING");
        request.setRemarks(requestDto.getRemarks());
        request.setRequestDate(LocalDate.now());

        return assistanceRequestRepository.save(request);
    }

    public AssistanceRequest approveRequest(Long requestId, String username) {
        AssistanceRequest request = validateCoachRequest(requestId, username);
        request.setStatus("APPROVED");
        return assistanceRequestRepository.save(request);
    }

    public AssistanceRequest rejectRequest(Long requestId, String username) {
        AssistanceRequest request = validateCoachRequest(requestId, username);
        request.setStatus("REJECTED");
        return assistanceRequestRepository.save(request);
    }

    public List<AssistanceRequest> getRequestsForCoach(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        Coach coach = coachRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Coach profile not found."));
        return assistanceRequestRepository.findByCoach_CoachId(coach.getCoachId());
    }

    public List<AssistanceRequest> getRequestsForAthlete(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        Athlete athlete = athleteRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Athlete profile not found."));
        return assistanceRequestRepository.findByAthlete_AthleteId(athlete.getAthleteId());
    }

    private AssistanceRequest validateCoachRequest(Long requestId, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        Coach coach = coachRepository.findByUserId(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Coach profile not found."));
        AssistanceRequest request = assistanceRequestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found."));

        if (!request.getCoach().getCoachId().equals(coach.getCoachId())) {
            throw new IllegalArgumentException("You are not authorized to modify this request.");
        }
        return request;
    }
}
