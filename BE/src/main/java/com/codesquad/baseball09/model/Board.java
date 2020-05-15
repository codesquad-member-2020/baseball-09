package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Board {

  private Long gameId;
  private int inning;

  @JsonIgnore
  private Long homeId;
  private String homeName;
  private int homeScore;
  @JsonIgnore
  private int homeOrder;

  @JsonIgnore
  private Long awayId;
  private String awayName;
  private int awayScore;
  @JsonIgnore
  private int awayOrder;

  private boolean isBottom;

  private Game game;
  private InningStatus status;
  private List<BattingLog> log;

  private Board(Long gameId, int inning, Long homeId, String homeName, int homeScore, int homeOrder,
      Long awayId, String awayName, int awayScore, int awayOrder, boolean isBottom, Game game,
      InningStatus status,
      List<BattingLog> log) {
    this.gameId = gameId;
    this.inning = inning;
    this.homeId = homeId;
    this.homeName = homeName;
    this.homeScore = homeScore;
    this.homeOrder = homeOrder;
    this.awayId = awayId;
    this.awayName = awayName;
    this.awayScore = awayScore;
    this.awayOrder = awayOrder;
    this.isBottom = isBottom;
    this.game = game;
    this.status = status;
    this.log = log;
  }

  public void change() {
    this.homeOrder = 0;
    this.awayOrder = 0;

    if (isBottom) {
      isBottom = false;
      this.inning++;
    } else {
      isBottom = true;
    }
  }

  public Long getGameId() {
    return gameId;
  }

  public int getInning() {
    return inning;
  }

  public Long getHomeId() {
    return homeId;
  }

  public String getHomeName() {
    return homeName;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getHomeOrder() {
    return homeOrder;
  }

  public Long getAwayId() {
    return awayId;
  }

  public String getAwayName() {
    return awayName;
  }

  public int getAwayScore() {
    return awayScore;
  }

  public int getAwayOrder() {
    return awayOrder;
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

  public List<BattingLog> getLog() {
    return log;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("gameId", gameId)
        .append("inning", inning)
        .append("homeId", homeId)
        .append("homeName", homeName)
        .append("homeScore", homeScore)
        .append("homeOrder", homeOrder)
        .append("awayId", awayId)
        .append("awayName", awayName)
        .append("awayScore", awayScore)
        .append("awayOrder", awayOrder)
        .append("isBottom", isBottom)
        .append("game", game)
        .append("status", status)
        .append("log", log)
        .toString();
  }

  public static final class Builder {

    private Long gameId;
    private int inning;
    private String homeName;
    private Long homeId;
    private int homeScore;
    private int homeOrder;
    private Long awayId;
    private String awayName;
    private int awayScore;
    private int awayOrder;
    private boolean isBottom;
    private Game game;
    private InningStatus status;
    private List<BattingLog> log;

    private Builder() {
    }

    public static Builder of() {
      return new Builder();
    }

    public Builder(Board board) {
      this.gameId = board.gameId;
      this.inning = board.inning;
      this.homeId = board.homeId;
      this.homeName = board.homeName;
      this.homeScore = board.homeScore;
      this.homeOrder = board.homeOrder;
      this.awayId = board.awayId;
      this.awayName = board.awayName;
      this.awayScore = board.awayScore;
      this.awayOrder = board.awayOrder;
      this.isBottom = board.isBottom;
      this.game = board.game;
      this.status = board.status;
      this.log = board.log;
    }

    public Builder gameId(Long gameId) {
      this.gameId = gameId;
      return this;
    }

    public Builder inning(int inning) {
      this.inning = inning;
      return this;
    }

    public Builder homeId(Long homeId) {
      this.homeId = homeId;
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

    public Builder homeOrder(int homeOrder) {
      if (homeOrder > 8) {
        this.homeOrder = 0;
      } else {
        this.homeOrder = homeOrder;
      }
      return this;
    }

    public Builder awayId(Long awayId) {
      this.awayId = awayId;
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

    public Builder awayOrder(int awayOrder) {
      if (awayOrder > 8) {
        this.awayOrder = 0;
      } else {
        this.awayOrder = awayOrder;
      }
      return this;
    }

    public Builder isBottom(boolean isBottom) {
      this.isBottom = isBottom;
      return this;
    }

    public Builder game(Game game) {
      this.game = game;
      this.homeId(game.getHomeTeamId());
      this.awayId(game.getAwayTeamId());
      return this;
    }

    public Builder status(InningStatus status) {
      this.status = status;
      return this;
    }

    public Builder score(List<Score> scores) {
      for (int i = 0; i < scores.size(); i++) {
        Score score = scores.get(i);
        if (score.getTeamId().equals(homeId)) {
          homeName(score.getName());
          homeScore(score.getScore());
        }
        if (score.getTeamId().equals(awayId)) {
          awayName(score.getName());
          awayScore(score.getScore());
        }
      }
      return this;
    }

    public Builder log(List<BattingLog> log) {
      this.log = log;
      return this;
    }

    public Board build() {
      return new Board(gameId, inning, homeId, homeName, homeScore, homeOrder, awayId, awayName,
          awayScore, awayOrder, isBottom, game, status, log);
    }
  }
}
