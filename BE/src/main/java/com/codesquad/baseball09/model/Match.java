package com.codesquad.baseball09.model;

public class Match {

  private final String home;
  private final String away;

  public Match(String home, String away) {
    this.home = home;
    this.away = away;
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }
}
