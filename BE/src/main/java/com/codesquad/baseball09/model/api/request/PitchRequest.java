package com.codesquad.baseball09.model.api.request;

public class PitchRequest {

  private Long gameId;
  private Long teamId;
  private Long playerId;
  private int inning;
  private int battingAverage;

  public Long getGameId() {
    return gameId;
  }

  public Long getTeamId() {
    return teamId;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public int getInning() {
    return inning;
  }

  public int getBattingAverage() {
    return battingAverage;
  }
}
