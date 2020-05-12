package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Board {

  private final Long gameId;
  private int inning;
  private List<Score> scores;
  @JsonIgnore
  private int homeScore;
  @JsonIgnore
  private int awayScore;
  private boolean isBottom;
  private SBO sbo;
  private Game game;

  public Board(Long gameId) {
    this.gameId = gameId;
    this.inning = 1;
    this.isBottom = false;
    this.homeScore = 0;
    this.awayScore = 0;
    this.sbo = new SBO(0, 0, 0, 0);
  }

  public void change() {
    if (this.isBottom) {
      this.isBottom = false;
      this.inning++;
    } else {
      this.isBottom = true;
    }
    this.homeScore = 0;
    this.awayScore = 0;
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

  public SBO getSbo() {
    return sbo;
  }

  public Game getGame() {
    return game;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
  }

  public List<Score> getScores() {
    return scores;
  }

  public void addInning() {
    this.inning++;
    this.sbo = new SBO(0, 0, 0, 0);
  }

  public void addHomeScore() {
    this.homeScore++;
  }

  public void addAwayScore() {
    this.awayScore++;
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
        .append("homeScore", homeScore)
        .append("awayScore", awayScore)
        .append("isBottom", isBottom)
        .append("sbo", sbo)
        .append("game", game)
        .toString();
  }
}
