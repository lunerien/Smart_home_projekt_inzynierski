package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class LocationGroupNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = 1176302563081527055L;
  private final String uuid;

  public LocationGroupNotFoundException(String uuid) {
    super("Location group with UUID: [" + uuid+"]");
    this.uuid = uuid;
  }
}
