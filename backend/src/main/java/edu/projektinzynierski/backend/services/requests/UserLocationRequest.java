package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserLocationRequest extends UserAccessRequest {
  private String uuid;
  private String userUuid;
  private String locationUuid;
  private String permissionLevel;
}
