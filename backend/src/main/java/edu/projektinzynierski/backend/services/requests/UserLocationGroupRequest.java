package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class UserLocationGroupRequest {
  private String uuid;
  private String userUuid;
  private String locationGroupUuid;
  private String permissionLevel;
}
