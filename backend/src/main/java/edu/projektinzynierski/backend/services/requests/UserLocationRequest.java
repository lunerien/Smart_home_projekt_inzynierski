package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class UserLocationRequest {
  private String uuid;
  private String userUuid;
  private String locationUuid;
  private String permissionLevel;
}
