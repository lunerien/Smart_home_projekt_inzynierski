package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ConnectedUsersRequest extends UserAccessRequest {
  private String uuid;
  private String user1uuid;
  private String user2uuid;
}
