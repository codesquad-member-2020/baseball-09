package com.codesquad.baseball09.model;

import java.util.Arrays;

public enum Status {
  STRIKE(1),
  BALL(2),
  OUT(3),
  HIT(4);

  private final int value;

  Status(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  static Status of(int value) {
    return Arrays.stream(values())
        .filter(v -> value == v.getValue())
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 Status 입력입니다"));
  }
}
