package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserLocationGroupRequest extends UserAccessRequest {
  private String uuid;
  private String userUuid;
  private String locationGroupUuid;
  private String permissionLevel;
}
