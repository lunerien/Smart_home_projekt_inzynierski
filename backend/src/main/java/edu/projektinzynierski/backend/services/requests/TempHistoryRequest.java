package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class TempHistoryRequest {
  private String uuid;
  private Integer temp;
  private String deviceUuid;
}
