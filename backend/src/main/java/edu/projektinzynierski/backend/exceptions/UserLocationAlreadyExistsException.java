package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
@EqualsAndHashCode(callSuper = true)
public class UserLocationAlreadyExistsException extends EntityAlreadyExistsException{

  private static final long serialVersionUID = -693246513451783102L;
  private final String uuid;

  public UserLocationAlreadyExistsException(String uuid) {
    super("UserLocation with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }
}
