package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class ConnectedUsersAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = -8281737157642690559L;
  private final String uuid;

  public ConnectedUsersAlreadyExistsException(String uuid) {
    super("ConnectedUsers with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }

}
