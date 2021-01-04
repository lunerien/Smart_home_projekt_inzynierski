package edu.projektinzynierski.backend.services.requests;

import lombok.Data;

@Data
public class ConnectedUsersRequest {
  private String uuid;
  private String user1uuid;
  private String user2uuid;
}
