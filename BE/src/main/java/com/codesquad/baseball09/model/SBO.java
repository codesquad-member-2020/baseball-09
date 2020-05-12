package com.codesquad.baseball09.model;

import static com.codesquad.baseball09.model.State.BALL;
import static com.codesquad.baseball09.model.State.HIT;
import static com.codesquad.baseball09.model.State.OUT;
import static com.codesquad.baseball09.model.State.STRIKE;

public class SBO {

  private int strike;
  private int ball;
  private int out;
  private int hit;

  public SBO(int strike, int ball, int out, int hit) {
    this.strike = strike;
    this.ball = ball;
    this.out = out;
    this.hit = hit;
  }

  public void refresh() {

  }

  public void plus(State state) {

    if (STRIKE.equals(state)) {
      strike++;
    }
    if (BALL.equals(state)) {
      ball++;
    }
    if (OUT.equals(state)) {
      out++;
    }
    if (HIT.equals(state)) {
      hit++;
    }
  }

  public void minus(State state) {

    if (STRIKE.equals(state)) {
      strike--;
    }
    if (BALL.equals(state)) {
      ball--;
    }
    if (OUT.equals(state)) {
      out--;
    }
    if (HIT.equals(state)) {
      hit--;
    }
  }

  public int getStrike() {
    return strike;
  }

  public SBO setStrike(int strike) {
    this.strike = strike;
    return this;
  }

  public int getBall() {
    return ball;
  }

  public SBO setBall(int ball) {
    this.ball = ball;
    return this;
  }

  public int getOut() {
    return out;
  }

  public SBO setOut(int out) {
    this.out = out;
    return this;
  }

  public int getHit() {
    return hit;
  }

  public SBO setHit(int hit) {
    this.hit = hit;
    return this;
  }
}
