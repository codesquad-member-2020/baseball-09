package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BattingLog {

  private Long id;
  private Long gameId;
  private Long playerId;
  private int inning;
  private Status status;

  private BattingLog(Long id, Long gameId, Long playerId, int inning,
      Status status) {
    this.id = id;
    this.gameId = gameId;
    this.playerId = playerId;
    this.inning = inning;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public Long getGameId() {
    return gameId;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public int getInning() {
    return inning;
  }

  public Status getStatus() {
    return status;
  }

  @JsonIgnore
  public int getStatusInt() {
    return status.getValue();
  }

  public static class Builder {

    private Long id;
    private Long gameId;
    private Long playerId;
    private int inning;
    private Status status;

    public Builder() {
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder playerId(Long playerId) {
      this.playerId = playerId;
      return this;
    }

    public Builder inning(int inning) {
      this.inning = inning;
      return this;
    }

    public Builder status(int value) {
      this.status = Status.of(value);
      return this;
    }

    public BattingLog build() {
      return new BattingLog(id, gameId, playerId, inning, status);
    }
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("gameId", gameId)
        .append("playerId", playerId)
        .append("inning", inning)
        .append("status", status)
        .toString();
  }
}
