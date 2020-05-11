package com.codesquad.baseball09.controller;

import com.codesquad.baseball09.error.AlreadySelectedException;
import com.codesquad.baseball09.model.api.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GeneralExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

  private ResponseEntity<ApiResult> newResponse(Exception exception, HttpStatus status) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("ContentType", "application/json");
    return new ResponseEntity<>(ApiResult.ERROR(exception, status), httpHeaders, status);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<?> handleNotFoundException(Exception e) {
    return newResponse(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AlreadySelectedException.class)
  public ResponseEntity<?> teamAlreadySelectedException(Exception e) {
    return newResponse(e, HttpStatus.BAD_REQUEST);
  }

}
