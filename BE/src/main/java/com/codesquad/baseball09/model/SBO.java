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

  public int plus(State state) {
    int value = 0;

    if (STRIKE.equals(state)) {
      strike++;
      value = checkThreeStrike();
    } else if (BALL.equals(state)) {
      ball++;
      value = checkFourBall();
    } else if (OUT.equals(state)) {
      out++;
      resetStrikeAndBall();
      value = checkThreeOut();
    } else if (HIT.equals(state)) {
      hit++;
      resetStrikeAndBall();
      value = checkFourHit();
    }
    return value;
  }

  private void resetStrikeAndBall() {
    this.strike = 0;
    this.ball = 0;
  }

  private void resetAll() {
    resetStrikeAndBall();
    this.out = 0;
    this.hit = 0;
  }

  private int checkFourHit() {
    if (this.hit == 4) {
      resetStrikeAndBall();
      this.hit--;
      return 1;
    }
    return 0;
  }

  private int checkThreeOut() {
    if (this.out == 3) {
      resetAll();
      return -1;
    }
    return 0;
  }

  private int checkFourBall() {
    if (this.ball == 4) {
      resetStrikeAndBall();
      plus(HIT);
    }
    return 0;
  }

  private int checkThreeStrike() {
    if (this.strike == 3) {
      resetStrikeAndBall();
      plus(OUT);
    }
    return 0;
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
