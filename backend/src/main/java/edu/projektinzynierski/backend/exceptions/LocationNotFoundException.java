package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class LocationNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = 3205516984843990681L;
  private final String uuid;

  public LocationNotFoundException(String uuid) {
    super("Location with UUID: [" + uuid + "]");
    this.uuid = uuid;
  }
}
