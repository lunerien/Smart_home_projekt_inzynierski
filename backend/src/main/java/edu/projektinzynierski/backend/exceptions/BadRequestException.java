package edu.projektinzynierski.backend.exceptions;

import edu.projektinzynierski.backend.errors.model.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class BadRequestException extends BusinessException {

  private static final long serialVersionUID = 535729686873596889L;

  public BadRequestException(String message) {
    super(message);
  }

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.BAD_REQUEST;
  }

  @Override
  public ErrorCode getErrorCode() {
    return ErrorCode.WRONG_REQUEST;
  }
}
