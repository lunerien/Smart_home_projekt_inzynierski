package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class LocationRequest extends UserAccessRequest {
  private String uuid;
  private String locationName;
  private String locationGroupUuid;
}
