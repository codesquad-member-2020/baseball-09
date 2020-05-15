package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DetailScore {

  @JsonIgnore
  private Long id;
  private Long gameId;
  private Long teamId;
  private int inning;
  private int score;

  public DetailScore(Long id, Long gameId, Long teamId, int inning, int score) {
    this.id = id;
    this.gameId = gameId;
    this.teamId = teamId;
    this.inning = inning;
    this.score = score;
  }

  public DetailScore(Long gameId, Long teamId, int inning, int score,
      Boolean isBottom) {
    this.gameId = gameId;
    this.teamId = teamId;
    this.inning = inning;
    this.score = score;
  }

  public void addScore() {
    this.score++;
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


  public static final class Builder {

    private Long id;
    private Long gameId;
    private Long teamId;
    private int inning;
    private int score;

    private Builder() {
    }

    public static Builder aDetailScore() {
      return new Builder();
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder teamId(Long teamId) {
      this.teamId = teamId;
      return this;
    }

    public Builder inning(int inning) {
      this.inning = inning;
      return this;
    }

    public Builder score(int score) {
      this.score = score;
      return this;
    }

    public DetailScore build() {
      return new DetailScore(id, gameId, teamId, inning, score);
    }
  }
}
