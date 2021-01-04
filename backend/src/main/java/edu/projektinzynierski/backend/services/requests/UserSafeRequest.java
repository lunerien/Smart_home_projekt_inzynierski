package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class UserSafeRequest {
  private String uuid;
  private String login;
  private String level;
}
