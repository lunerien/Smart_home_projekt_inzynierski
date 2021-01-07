package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class UserLocationGroupAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = -4290972868028444867L;
  private final String uuid;

  public UserLocationGroupAlreadyExistsException(String uuid) {
    super("UserLocationGroup with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
