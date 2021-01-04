package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class UserPostUpdateRequest {
  private String uuid;
  private String login;
  private String level;
  private String password;
}
