package edu.projektinzynierski.backend.services.requests;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class TempHistoryRequest extends UserAccessRequest {
  private String uuid;
  private Double temp;
  private String deviceUuid;
}
