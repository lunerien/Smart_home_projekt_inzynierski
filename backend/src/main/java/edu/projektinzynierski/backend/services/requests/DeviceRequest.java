package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class DeviceRequest extends UserAccessRequest {
  private String uuid;
  private String deviceId;
  private String type;
  private String locationUuid;
}
