package com.codesquad.baseball09.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Board {

  private final Long gameId;
  private int inning;
  private int homeScore;
  private int awayScore;
  private boolean isBottom;
  private SBO sbo;
  private Game game;
  private List<Score> scores = new ArrayList<>();

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
    this.sbo = new SBO(0, 0, 0, 0);
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

  public List<Score> getScores() {
    return scores;
  }

  public int getHomeScore() {
    return homeScore;
  }

  public int getAwayScore() {
    return awayScore;
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

  public Board addPlayers(List<Player> home, List<Player> away) {
    this.game = Game.of(home, away);
    return this;
  }

  public Board addScoreList(List<Score> scores) {
    this.scores = scores;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("inning", inning)
        .append("isBottom", isBottom)
        .append("sbo", sbo)
        .append("game", game)
        .append("scores", scores)
        .toString();
  }
}
