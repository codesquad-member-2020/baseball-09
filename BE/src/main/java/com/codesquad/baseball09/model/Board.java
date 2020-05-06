package com.codesquad.baseball09.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Board {

  private String homeName;

  private String awayName;

  private int homeScore;

  private int awayScore;

  private int inning;

  private int strike;

  private int ball;

  private int out;

  public Board(String homeName, String awayName) {
    this.homeName = homeName;
    this.awayName = awayName;
    this.homeScore = 0;
    this.awayScore = 0;
    this.inning = 1;
    this.strike = 0;
    this.ball = 0;
    this.out = 0;
  }

  public void addStrike() {
    strike++;
    if (strike == 3) {
      addOut();
      strike = 0;
    }
  }

  public void addBall() {
    ball++;
    if (ball == 4) {
      ball = 0;
    }
  }

  public void addOut() {
    out++;
    if (out == 3) {
      strike = 0;
      ball = 0;
      out = 0;
    }
  }


  public String getHomeName() {
    return homeName;
  }

  public String getAwayName() {
    return awayName;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
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

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("homeName", homeName)
        .append("awayName", awayName)
        .append("homeScore", homeScore)
        .append("awayScore", awayScore)
        .append("inning", inning)
        .append("strike", strike)
        .append("ball", ball)
        .append("out", out)
        .toString();
  }
}
