package com.codesquad.baseball09.model;

public class Match {

  private final Long id;
  private final String home;
  private final String away;
  private final boolean started;

  public Match(Long id, String home, String away, boolean started) {
    this.id = id;
    this.home = home;
    this.away = away;
    this.started = started;
  }

  public Long getId() {
    return id;
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public boolean isStarted() {
    return started;
  }
}
