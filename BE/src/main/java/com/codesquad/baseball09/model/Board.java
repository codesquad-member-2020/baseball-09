package com.codesquad.baseball09.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

  private final Team home;
  private final Team away;

  private final int inning;
  private final boolean inningStatus;

  private final int strike;
  private final int ball;
  private final int out;

  private final Game pitcherAndBatter;
  private final List<BatterLog> batterLog = new ArrayList<>();

  public Board(Team home, Team away, int inning, boolean inningStatus, int strike, int ball,
      int out,
      Game pitcherAndBatter) {
    this.home = home;
    this.away = away;
    this.inning = inning;
    this.inningStatus = inningStatus;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
    this.pitcherAndBatter = pitcherAndBatter;
  }

  public void addBatterLog(BatterLog log) {
    batterLog.add(log);
  }

  public Team getHome() {
    return home;
  }

  public Team getAway() {
    return away;
  }

  public int getInning() {
    return inning;
  }

  public boolean isInningStatus() {
    return inningStatus;
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

  public Game getPitcherAndBatter() {
    return pitcherAndBatter;
  }

  public List<BatterLog> getBatterLog() {
    return batterLog;
  }
}
