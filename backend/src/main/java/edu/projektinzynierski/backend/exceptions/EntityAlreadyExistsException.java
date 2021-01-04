package edu.projektinzynierski.backend.exceptions;

import edu.projektinzynierski.backend.errors.model.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class EntityAlreadyExistsException extends BusinessException {

  private static final long serialVersionUID = -339418707067723519L;

  public EntityAlreadyExistsException(String message) {
    super(message);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.CONFLICT;
  }

  @Override
  public ErrorCode getErrorCode() {
    return ErrorCode.RESOURCE_ALREADY_EXISTS;
  }
}
