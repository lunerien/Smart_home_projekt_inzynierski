package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class UserAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = -1634572036089685625L;
  private final String uuid;

  public UserAlreadyExistsException(String uuid) {
    super("User with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
