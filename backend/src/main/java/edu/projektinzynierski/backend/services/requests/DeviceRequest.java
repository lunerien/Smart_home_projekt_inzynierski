package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class DeviceRequest {
  private String uuid;
  private String deviceId;
  private String type;
  private String locationUuid;
}
