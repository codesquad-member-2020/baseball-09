package com.codesquad.baseball09.model;

public class DetailPlayer {

  private Long gameId;
  private Long teamId;
  private Long playerId;
  private String name;
  private int atBat;
  private int hits;
  private int outs;

  private DetailPlayer(Long gameId, Long teamId, Long playerId, String name, int atBat, int hits,
      int outs) {
    this.gameId = gameId;
    this.teamId = teamId;
    this.playerId = playerId;
    this.name = name;
    this.atBat = atBat;
    this.hits = hits;
    this.outs = outs;
  }

  public Long getGameId() {
    return gameId;
  }

  public Long getTeamId() {
    return teamId;
  }

  public Long getPlayerId() {
    return playerId;
  }

  public String getName() {
    return name;
  }

  public int getAtBat() {
    return atBat;
  }

  public int getHits() {
    return hits;
  }

  public int getOuts() {
    return outs;
  }

  public static final class Builder {

    private Long gameId;
    private Long teamId;
    private Long playerId;
    private String name;
    private int atBat;
    private int hits;
    private int outs;

    private Builder() {
    }

    public static Builder of() {
      return new Builder();
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder teamId(Long teamId) {
      this.teamId = teamId;
      return this;
    }

    public Builder playerId(Long playerId) {
      this.playerId = playerId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder atBat(int atBat) {
      this.atBat = atBat;
      return this;
    }

    public Builder hits(int hits) {
      this.hits = hits;
      return this;
    }

    public Builder outs(int outs) {
      this.outs = outs;
      return this;
    }

    public DetailPlayer build() {
      return new DetailPlayer(gameId, teamId, playerId, name, atBat, hits, outs);
    }
  }
}
