package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class UserSafeRequest extends UserAccessRequest {
  private String uuid;
  private String login;
  private String level;
}
