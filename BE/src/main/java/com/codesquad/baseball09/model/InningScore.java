package com.codesquad.baseball09.model;

public class InningScore {

  private int inningStatus;
  private int homeScore;
  private int awayScore;

  public InningScore(int inningStatus, int homeScore, int awayScore) {
    this.inningStatus = inningStatus;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
  }

  public int getInningStatus() {
    return inningStatus;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
  }
}
