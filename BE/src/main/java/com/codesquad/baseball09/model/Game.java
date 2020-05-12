package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class Game {

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

  private Game(Player home, Player away,
      List<Player> homePlayers, List<Player> awayPlayers) {
    this.home = home;
    this.away = away;
    this.homePlayers = homePlayers;
    this.awayPlayers = awayPlayers;
    this.homeOrder = 0;
    this.awayOrder = 0;
  }

  public static Game of(List<Player> home, List<Player> away) {
    return new Game(home.get(0), away.get(0), home, away);
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
}
