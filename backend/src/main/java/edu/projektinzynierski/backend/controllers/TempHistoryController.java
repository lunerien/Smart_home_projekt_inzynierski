package edu.projektinzynierski.backend.controllers;

import edu.projektinzynierski.backend.services.TempHistoryService;
import edu.projektinzynierski.backend.services.requests.TempHistoryRequest;
import edu.projektinzynierski.backend.services.requests.UserAccessRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
public class TempHistoryController {
  private final TempHistoryService tempHistoryService;

  @GetMapping("/api/temp_histories")
  public List<TempHistoryRequest> read(@RequestBody UserAccessRequest userAccessRequest){
    return tempHistoryService.readTempHistories(userAccessRequest);
  }
}
