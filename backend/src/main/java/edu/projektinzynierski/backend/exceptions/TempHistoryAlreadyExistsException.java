package edu.projektinzynierski.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TempHistoryAlreadyExistsException extends EntityAlreadyExistsException{

  private static final long serialVersionUID = -6673635868458006065L;
  private final String uuid;
  public TempHistoryAlreadyExistsException(String uuid) {
    super("TempHistory with UUID: ["+ uuid+"]");
    this.uuid = uuid;
  }
}
