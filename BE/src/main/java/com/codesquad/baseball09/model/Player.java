package com.codesquad.baseball09.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Player {

  private final Long id;
  private final Long teamId;
  private final String name;
  private final int battingAverage;

  public Player(Long id, Long teamId, String name, int battingAverage) {
    this.id = id;
    this.teamId = teamId;
    this.name = name;
    this.battingAverage = battingAverage;
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

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("teamId", teamId)
        .append("name", name)
        .append("battingAverage", battingAverage)
        .toString();
  }
}
