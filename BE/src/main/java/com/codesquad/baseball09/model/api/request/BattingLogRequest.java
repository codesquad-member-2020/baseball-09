package com.codesquad.baseball09.model.api.request;

public class BattingLogRequest {

  private Long gameId;
  private int inning;

  private BattingLogRequest(Long gameId, int inning) {
    this.gameId = gameId;
    this.inning = inning;
  }

  public static BattingLogRequest of(Long gameId, int inning) {
    return new BattingLogRequest(gameId, inning);
  }

  public Long getGameId() {
    return gameId;
  }

  public int getInning() {
    return inning;
  }
}
