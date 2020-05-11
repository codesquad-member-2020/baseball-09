package com.codesquad.baseball09.error;

public class AlreadySelectedException extends RuntimeException {

  public AlreadySelectedException(String message) {
    super("Team Already Selected : " + message);
  }
}
