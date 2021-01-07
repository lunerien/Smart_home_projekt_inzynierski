package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class LocationAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = 7479658686913740420L;
  private final String uuid;

  public LocationAlreadyExistsException(String uuid) {
    super("Location with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
