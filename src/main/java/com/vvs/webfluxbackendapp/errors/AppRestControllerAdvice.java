package com.vvs.webfluxbackendapp.errors;

import com.vvs.webfluxbackendapp.errors.exception.UserAlreadyExistException;
import com.vvs.webfluxbackendapp.errors.exception.UserNotFoundException;
import com.vvs.webfluxbackendapp.errors.exception.WrongCredentialException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j2;

import static com.vvs.webfluxbackendapp.errors.Error.WRONG_CREDENTIALS;
import static com.vvs.webfluxbackendapp.errors.Error.USER_NOT_FOUND;
import static com.vvs.webfluxbackendapp.errors.Error.USER_ALREADY_EXISTS;

@Log4j2
@RestControllerAdvice
public class AppRestControllerAdvice {
  
  @ExceptionHandler(value = WrongCredentialException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public Error wrongCredentialException(final WrongCredentialException e) {
    return WRONG_CREDENTIALS;
  }

  @ExceptionHandler(value = UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public Error wrongCredentialException(final UserNotFoundException e) {
    return USER_NOT_FOUND;
  }

  @ExceptionHandler(value = UserAlreadyExistException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public Error wrongCredentialException(final UserAlreadyExistException e) {
    return USER_ALREADY_EXISTS;
  }
}
