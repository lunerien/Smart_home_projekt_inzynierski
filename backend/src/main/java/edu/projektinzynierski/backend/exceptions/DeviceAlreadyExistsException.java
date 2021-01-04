package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class DeviceAlreadyExistsException extends EntityAlreadyExistsException {

  private static final long serialVersionUID = -3088026712242500807L;
  private final String uuid;

  public DeviceAlreadyExistsException(String uuid) {
    super("Device with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }
}
