package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class LocationRequest {
  private String uuid;
  private String locationName;
  private String locationGroupUuid;
}
