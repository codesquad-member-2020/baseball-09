package com.codesquad.baseball09.model.api.request;

public class PitchRequest {

  private Long gameId;
  private int inning;
  private Long playerId;
  private int battingAverage;

  public Long getGameId() {
    return gameId;
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
