package edu.projektinzynierski.backend.exceptions;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class DeviceNotFoundException extends EntityNotFoundException {

  private static final long serialVersionUID = 363296846762830931L;
  private final UUID uuid;
  private final String deviceId;

  public DeviceNotFoundException(UUID uuid) {
    super("Device with UUID: [" + uuid.toString() + "]");
    this.uuid = uuid;
    this.deviceId = null;
  }

  public DeviceNotFoundException(String deviceId) {
    super("Device with Id: [" + deviceId + "]");
    this.uuid = null;
    this.deviceId = deviceId;
  }
}
