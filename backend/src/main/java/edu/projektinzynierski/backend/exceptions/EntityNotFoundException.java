package edu.projektinzynierski.backend.exceptions;

import edu.projektinzynierski.backend.errors.model.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class EntityNotFoundException extends BusinessException {

  private static final long serialVersionUID = -2220335668037270233L;

  public EntityNotFoundException(String message) {
    super("Entity not found: " + message);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.NOT_FOUND;
  }

  @Override
  public ErrorCode getErrorCode() {
    return ErrorCode.RESOURCE_NOT_FOUND;
  }


}
