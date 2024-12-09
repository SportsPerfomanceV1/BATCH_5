package SpringInfo.ProjectDemo.AdminApp.Controller;

import SpringInfo.ProjectDemo.EventResultApp.Dto.EventRequest;
import SpringInfo.ProjectDemo.EventResultApp.Dto.EventResultRequestDto;
import SpringInfo.ProjectDemo.EventResultApp.Model.EventResult;
import SpringInfo.ProjectDemo.EventResultApp.Service.EventResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class EventResultController {

    @Autowired
    private EventResultService eventResultService;

    public EventResultController(EventResultService eventResultService) {
        this.eventResultService = eventResultService;
    }


    @PostMapping("/publish")
    public ResponseEntity<EventResult> publishEventResult(@RequestBody EventResultRequestDto request) {
        try {
            // Using the values from the request body to call the service
            EventResult result = eventResultService.publishResult(
                    request.getAthleteId(),
                    request.getEventId(),
                    request.getScore(),
                    request.getRemarks()
            );
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping("/view")
    public ResponseEntity<List<EventResult>> getResultsForEvent(@RequestBody EventRequest eventRequest) {
        try {
            // Fetch the results for the event using the eventId from the request body
            List<EventResult> results = eventResultService.getResultsForEvent(eventRequest.getEventId());
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}