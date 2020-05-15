package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game {

  @JsonIgnore
  private Long homeTeamId;

  @JsonIgnore
  private Long awayTeamId;

  private Player home;

  private Player away;

  private Game(Player home, Player away) {
    this.homeTeamId = home.getTeamId();
    this.awayTeamId = away.getTeamId();
    this.home = home;
    this.away = away;
  }

  public static Game of(Player home, Player away) {
    return new Game(home, away);
  }

  public Long getHomeTeamId() {
    return homeTeamId;
  }

  public Long getAwayTeamId() {
    return awayTeamId;
  }

  public Player getHome() {
    return home;
  }

  public Player getAway() {
    return away;
  }

}
