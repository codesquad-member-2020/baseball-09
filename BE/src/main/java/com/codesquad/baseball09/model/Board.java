package com.codesquad.baseball09.model;

public class Board {

  private Long gameId;
  private int inning;

  private String homeName;
  private int homeScore;

  private String awayName;
  private int awayScore;
  private boolean isBottom;

  private Game game;
  private InningStatus status;
  private BattingLog log;

  public Board(Long gameId, int inning, String homeName, int homeScore, String awayName,
      int awayScore, boolean isBottom, Game game, InningStatus status,
      BattingLog log) {
    this.gameId = gameId;
    this.inning = inning;
    this.homeName = homeName;
    this.homeScore = homeScore;
    this.awayName = awayName;
    this.awayScore = awayScore;
    this.isBottom = isBottom;
    this.game = game;
    this.status = status;
    this.log = log;
  }

  public Long getGameId() {
    return gameId;
  }

  public int getInning() {
    return inning;
  }

  public String getHomeName() {
    return homeName;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public String getAwayName() {
    return awayName;
  }

  public int getAwayScore() {
    return awayScore;
  }

  public boolean isBottom() {
    return isBottom;
  }

  public Game getGame() {
    return game;
  }

  public InningStatus getStatus() {
    return status;
  }

  public BattingLog getLog() {
    return log;
  }


  public static final class Builder {

    private Long gameId;
    private int inning;
    private String homeName;
    private int homeScore;
    private String awayName;
    private int awayScore;
    private boolean isBottom;
    private Game game;
    private InningStatus status;
    private BattingLog log;

    private Builder() {
    }

    public static Builder aBoard() {
      return new Builder();
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder inning(int inning) {
      this.inning = inning;
      return this;
    }

    public Builder homeName(String homeName) {
      this.homeName = homeName;
      return this;
    }

    public Builder homeScore(int homeScore) {
      this.homeScore = homeScore;
      return this;
    }

    public Builder awayName(String awayName) {
      this.awayName = awayName;
      return this;
    }

    public Builder awayScore(int awayScore) {
      this.awayScore = awayScore;
      return this;
    }

    public Builder isBottom(boolean isBottom) {
      this.isBottom = isBottom;
      return this;
    }

    public Builder game(Game game) {
      this.game = game;
      return this;
    }

    public Builder status(InningStatus status) {
      this.status = status;
      return this;
    }

    public Builder log(BattingLog log) {
      this.log = log;
      return this;
    }

    public Board build() {
      return new Board(gameId, inning, homeName, homeScore, awayName, awayScore, isBottom, game,
          status, log);
    }
  }
}
