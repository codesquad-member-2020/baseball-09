package com.codesquad.baseball09.model;

import static com.codesquad.baseball09.model.Status.BALL;
import static com.codesquad.baseball09.model.Status.HIT;
import static com.codesquad.baseball09.model.Status.OUT;
import static com.codesquad.baseball09.model.Status.STRIKE;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InningStatus {

  @JsonIgnore
  private Long id;
  private Long gameId;
  private int inning;
  private int strike;
  private int ball;
  private int out;
  private int hit;

  public InningStatus(Long id, Long gameId, int inning, int strike, int ball, int out, int hit) {
    this.id = id;
    this.gameId = gameId;
    this.inning = inning;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
    this.hit = hit;
  }

  private InningStatus(Long gameId, int inning, int strike, int ball, int out, int hit) {
    this.gameId = gameId;
    this.inning = inning;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
    this.hit = hit;
  }

  public InningStatus(int strike, int ball, int out, int hit) {
    this.strike = strike;
    this.ball = ball;
    this.out = out;
    this.hit = hit;
  }

  public static InningStatus of(Long gameId, int inning, int strike, int ball, int out, int hit) {
    return new InningStatus(gameId, inning, strike, ball, out, hit);
  }

  public int plus(Status status) {
    int value = 0;

    if (STRIKE.equals(status)) {
      strike++;
      value = checkThreeStrike();
    } else if (BALL.equals(status)) {
      ball++;
      value = checkFourBall();
    } else if (OUT.equals(status)) {
      out++;
      resetStrikeAndBall();
      value = checkThreeOut();
    } else if (HIT.equals(status)) {
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

  public Long getId() {
    return id;
  }

  public Long getGameId() {
    return gameId;
  }

  public int getInning() {
    return inning;
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

  public static final class Builder {

    private Long id;
    private Long gameId;
    private int inning;
    private int strike;
    private int ball;
    private int out;
    private int hit;

    public Builder() {
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder inning(int inning) {
      this.inning = inning;
      return this;
    }

    public Builder strike(int strike) {
      this.strike = strike;
      return this;
    }

    public Builder ball(int ball) {
      this.ball = ball;
      return this;
    }

    public Builder out(int out) {
      this.out = out;
      return this;
    }

    public Builder hit(int hit) {
      this.hit = hit;
      return this;
    }

    public InningStatus build() {
      return new InningStatus(id, gameId, inning, strike, ball, out, hit);
    }
  }
}
