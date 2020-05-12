package com.codesquad.baseball09.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Player {

  private final Long id;
  private final Long teamId;
  private final String name;
  private final int battingAverage;
  private final Boolean isPitcher;

  public Player(Long id, Long teamId, String name, int battingAverage, Boolean isPitcher) {
    this.id = id;
    this.teamId = teamId;
    this.name = name;
    this.battingAverage = battingAverage;
    this.isPitcher = isPitcher;
  }

  public Long getId() {
    return id;
  }

  public Long getTeamId() {
    return teamId;
  }

  public String getName() {
    return name;
  }

  public int getBattingAverage() {
    return battingAverage;
  }

  public Boolean getPitcher() {
    return isPitcher;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("teamId", teamId)
        .append("name", name)
        .append("battingAverage", battingAverage)
        .append("isPitcher", isPitcher)
        .toString();
  }
}
