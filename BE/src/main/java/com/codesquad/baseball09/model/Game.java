package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private Player home;

  private Player away;

  @JsonIgnore
  private List<Player> homePlayers = new ArrayList<>();
  @JsonIgnore
  private List<Player> awayPlayers = new ArrayList<>();

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

  private Game(Player home, Player away) {
    this.home = home;
    this.away = away;
  }

  public static Game of(List<Player> home, List<Player> away) {
    return new Game(home.get(0), away.get(0), home, away);
  }

  public void nextHome() {
    this.home = homePlayers.get(++homeOrder);
  }

  public void nextAway() {
    this.home = awayPlayers.get(++awayOrder);
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
