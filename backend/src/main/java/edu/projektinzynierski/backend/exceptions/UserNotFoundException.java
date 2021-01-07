package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class UserNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = 5554455089949266974L;
  private final String uuid;

  public UserNotFoundException(String uuid) {
    super("User with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
