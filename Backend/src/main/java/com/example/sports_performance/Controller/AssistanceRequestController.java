package com.example.sports_performance.Controller;

import com.example.sports_performance.DTO.AssistanceRequestDto;
import com.example.sports_performance.Model.AssistanceRequest;
import com.example.sports_performance.Service.AssistanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assistance")
public class AssistanceRequestController {

    @Autowired
    private AssistanceRequestService assistanceRequestService;

    @PostMapping("/request")
    public ResponseEntity<AssistanceRequest> createRequest(@RequestBody AssistanceRequestDto requestDto, @RequestParam String username) {
        return ResponseEntity.ok(assistanceRequestService.createRequest(requestDto, username));
    }

    @PutMapping("/approve/{requestId}")
    public ResponseEntity<AssistanceRequest> approveRequest(@PathVariable Long requestId, @RequestParam String username) {
        return ResponseEntity.ok(assistanceRequestService.approveRequest(requestId, username));
    }

    @PutMapping("/reject/{requestId}")
    public ResponseEntity<AssistanceRequest> rejectRequest(@PathVariable Long requestId, @RequestParam String username) {
        return ResponseEntity.ok(assistanceRequestService.rejectRequest(requestId, username));
    }

    @GetMapping("/coach")
    public ResponseEntity<List<AssistanceRequest>> getRequestsForCoach(@RequestParam String username) {
        return ResponseEntity.ok(assistanceRequestService.getRequestsForCoach(username));
    }

    @GetMapping("/athlete")
    public ResponseEntity<List<AssistanceRequest>> getRequestsForAthlete(@RequestParam String username) {
        return ResponseEntity.ok(assistanceRequestService.getRequestsForAthlete(username));
    }
}
