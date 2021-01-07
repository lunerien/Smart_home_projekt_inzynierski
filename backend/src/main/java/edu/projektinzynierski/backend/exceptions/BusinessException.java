package edu.projektinzynierski.backend.exceptions;

import edu.projektinzynierski.backend.errors.model.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class BusinessException extends RuntimeException {

  private static final long serialVersionUID = -5643095459089891926L;

  public BusinessException(String message) {
    super(message);
  }

  public abstract HttpStatus getHttpStatus();

  public abstract ErrorCode getErrorCode();
}
