package edu.projektinzynierski.backend.controllers;

import edu.projektinzynierski.backend.services.UserService;
import edu.projektinzynierski.backend.services.requests.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/api/register")
  public void create(@RequestBody UserLoginRequest request) {
    userService.registerUser(request);
  }

  @GetMapping("/api/login")
  public String login(@RequestBody UserLoginRequest userLoginRequest) {
    return userService.loginUser(userLoginRequest);
  }
}
