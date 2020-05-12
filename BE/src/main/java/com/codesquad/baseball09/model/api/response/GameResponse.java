package com.codesquad.baseball09.model.api.response;

public class GameResponse {

  private Long id;
  private Long matchId;

  public GameResponse(Long id, Long matchId) {
    this.id = id;
    this.matchId = matchId;
  }

  public Long getId() {
    return id;
  }

  public Long getMatchId() {
    return matchId;
  }
}
