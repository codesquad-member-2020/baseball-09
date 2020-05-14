package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class Game {

  private Long homeTeamId;

  private Long awayTeamId;

  private Player home;

  private Player away;

  @JsonIgnore
  private final List<Player> homePlayers;
  @JsonIgnore
  private final List<Player> awayPlayers;

  @JsonIgnore
  private int homeOrder;
  @JsonIgnore
  private int awayOrder;

  private Game(Long homeTeamId, Long awayTeamId, Player home, Player away,
      List<Player> homePlayers, List<Player> awayPlayers, int homeOrder, int awayOrder) {
    this.homeTeamId = homeTeamId;
    this.awayTeamId = awayTeamId;
    this.home = home;
    this.away = away;
    this.homePlayers = homePlayers;
    this.awayPlayers = awayPlayers;
    this.homeOrder = homeOrder;
    this.awayOrder = awayOrder;
  }

  public static Game of(Long homeTeamId, Long awayTeamId, List<Player> home,
      List<Player> away, int homeOrder, int awayOrder) {
    return new Game(homeTeamId, awayTeamId, home.get(0), away.get(0), home, away, homeOrder,
        awayOrder);
  }

  public void nextHome() {
    if (homePlayers.size() - 1 == homeOrder) {
      homeOrder = -1;
    }

    this.home = homePlayers.get(++homeOrder);
  }

  public void nextAway() {
    if (awayPlayers.size() - 1 == awayOrder) {
      awayOrder = -1;
    }

    this.away = awayPlayers.get(++awayOrder);
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

  public List<Player> getHomePlayers() {
    return homePlayers;
  }

  public List<Player> getAwayPlayers() {
    return awayPlayers;
  }

  public int getHomeOrder() {
    return homeOrder;
  }

  public int getAwayOrder() {
    return awayOrder;
  }
}
