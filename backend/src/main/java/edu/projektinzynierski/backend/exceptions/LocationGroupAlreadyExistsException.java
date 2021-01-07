package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class LocationGroupAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = -6055468843593914414L;
  private final String uuid;

  public LocationGroupAlreadyExistsException(String uuid) {
    super("LocationGroup with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
