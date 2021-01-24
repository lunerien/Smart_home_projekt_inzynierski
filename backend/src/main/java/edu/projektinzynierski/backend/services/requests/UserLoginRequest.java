package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {
  private String login;
  private String password;
}
