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

  public void add(State state) {
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

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  public int getOut() {
    return out;
  }

  public int getHit() {
    return hit;
  }
}
