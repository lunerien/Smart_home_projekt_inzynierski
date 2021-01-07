package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class UserLocationNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = -6621101199230536870L;
  private final String uuid;

  public UserLocationNotFoundException(String uuid) {
    super("UserLocation with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
