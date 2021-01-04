package edu.projektinzynierski.backend.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = true)
public class UserLocationGroupNotFoundException extends EntityNotFoundException{

  private static final long serialVersionUID = -6845467594537130649L;
  private final String uuid;

  public UserLocationGroupNotFoundException(String uuid) {
    super("UserLocationGroup with UUID: ["+uuid+"]");
    this.uuid = uuid;
  }
}
