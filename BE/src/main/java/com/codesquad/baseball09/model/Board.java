package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Board {

  private final Long gameId;
  private int inning;
  private int homeScore;
  private int awayScore;

  @JsonIgnore
  private List<Score> scores;
  @JsonIgnore
  private int homeInningScore;
  @JsonIgnore
  private int awayInningScore;
  private boolean isBottom;
  private InningStatus inningStatus;
  private Game game;

  public Board(Long gameId) {
    this.gameId = gameId;
    this.inning = 1;
    this.isBottom = false;
    this.homeScore = 0;
    this.awayScore = 0;
    this.homeInningScore = 0;
    this.awayInningScore = 0;
    this.inningStatus = new InningStatus(0, 0, 0, 0);
  }

  public void change() {
    if (this.isBottom) {
      this.isBottom = false;
      this.inning++;
    } else {
      this.isBottom = true;
    }
    this.homeInningScore = 0;
    this.awayInningScore = 0;
  }


  public Long getGameId() {
    return gameId;
  }

  public int getInning() {
    return inning;
  }

  public boolean isBottom() {
    return isBottom;
  }

  public InningStatus getInningStatus() {
    return inningStatus;
  }

  public Game getGame() {
    return game;
  }

  public int getHomeInningScore() {
    return homeInningScore;
  }

  public int getAwayInningScore() {
    return awayInningScore;
  }

  public List<Score> getScores() {
    return scores;
  }

  public void addInning() {
    this.inning++;
    this.inningStatus = new InningStatus(0, 0, 0, 0);
  }

  public void addHomeScore() {
    this.homeInningScore++;
  }

  public void addAwayScore() {
    this.awayInningScore++;
  }

  public Board addScore(List<Score> score) {
    this.scores = score;
    return this;
  }

  public Board addPlayers(List<Player> home, List<Player> away) {
    this.game = Game.of(home, away);
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("gameId", gameId)
        .append("inning", inning)
        .append("score", scores)
        .append("homeScore", homeInningScore)
        .append("awayScore", awayInningScore)
        .append("isBottom", isBottom)
        .append("sbo", inningStatus)
        .append("game", game)
        .toString();
  }
}
