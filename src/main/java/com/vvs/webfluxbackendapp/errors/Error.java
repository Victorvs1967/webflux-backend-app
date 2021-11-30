package com.vvs.webfluxbackendapp.errors;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Error implements Serializable {
  
  WRONG_CREDENTIALS(1000, "Wrong credentials"),
  UN_AUTHORIZED(1001, "User is un-authorize to access this resource"),
  USER_ALREADY_EXISTS(1002, "User already exists"),
  USER_NOT_FOUND(1003, "User not found");

  private int code;
  private String message;

  Error(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
