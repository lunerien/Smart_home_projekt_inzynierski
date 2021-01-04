package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class TempHistoryNotFoundException extends EntityNotFoundException{

  private static final long serialVersionUID = -5353456999072055273L;
  private final String uuid;

  public TempHistoryNotFoundException(String uuid) {
    super("TempHistory with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }
}
