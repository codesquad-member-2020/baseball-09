package com.codesquad.baseball09.model;

public enum State {
  STRIKE(1),
  BALL(2),
  OUT(3),
  HIT(4);

  private int value;

  State(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
