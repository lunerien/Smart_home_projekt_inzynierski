package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class ConnectedUsersNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = -5707833560380861182L;
  private final String uuid;

  public ConnectedUsersNotFoundException(String uuid) {
    super("ConnectedUsers with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
