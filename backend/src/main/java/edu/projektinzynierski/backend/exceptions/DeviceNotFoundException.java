package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class DeviceNotFoundException extends EntityNotFoundException{

  private static final long serialVersionUID = 363296846762830931L;
  private final String uuid;

  public DeviceNotFoundException(String uuid) {
    super("Device with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }
}
