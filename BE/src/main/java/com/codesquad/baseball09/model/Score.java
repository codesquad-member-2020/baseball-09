package com.codesquad.baseball09.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Score {

  private Long gameId;
  private Long teamId;
  private String name;
  private int score;

  public Score(Long gameId, Long teamId, String name, int score) {
    this.gameId = gameId;
    this.teamId = teamId;
    this.name = name;
    this.score = score;
  }

  public Long getGameId() {
    return gameId;
  }

  public Long getTeamId() {
    return teamId;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("gameId", gameId)
        .append("teamId", teamId)
        .append("name", name)
        .append("score", score)
        .toString();
  }
}
