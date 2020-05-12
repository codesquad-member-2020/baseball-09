package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Score {

  @JsonIgnore
  private Long id;
  private final Long gameId;
  private final Long teamId;
  private final int inning;
  private final int score;
  private final Boolean isBottom;

  public Score(Long id, Long gameId, Long teamId, int inning, int score,
      Boolean isBottom) {
    this.id = id;
    this.gameId = gameId;
    this.teamId = teamId;
    this.inning = inning;
    this.score = score;
    this.isBottom = isBottom;
  }

  public Score(Long gameId, Long teamId, int inning, int score,
      Boolean isBottom) {
    this.gameId = gameId;
    this.teamId = teamId;
    this.inning = inning;
    this.score = score;
    this.isBottom = isBottom;
  }


  public Long getId() {
    return id;
  }

  public Long getGameId() {
    return gameId;
  }

  public Long getTeamId() {
    return teamId;
  }

  public int getInning() {
    return inning;
  }

  public int getScore() {
    return score;
  }

  public Boolean getBottom() {
    return isBottom;
  }
}
