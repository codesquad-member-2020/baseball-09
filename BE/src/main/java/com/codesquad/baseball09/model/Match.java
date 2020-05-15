package com.codesquad.baseball09.model;

public class Match {

  private final Long id;
  private final Long homeId;
  private final Long awayId;
  private String home;
  private String away;
  private Boolean isStarted;

  public Match(Long id, Long homeId, Long awayId, String home, String away,
      Boolean isStarted) {
    this.id = id;
    this.homeId = homeId;
    this.awayId = awayId;
    this.home = home;
    this.away = away;
    this.isStarted = isStarted;
  }

  public Match(Long id, Long homeId, Long awayId) {
    this.id = id;
    this.homeId = homeId;
    this.awayId = awayId;
  }


  public Long getId() {
    return id;
  }

  public Long getHomeId() {
    return homeId;
  }

  public Long getAwayId() {
    return awayId;
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public Boolean getStarted() {
    return isStarted;
  }
}


