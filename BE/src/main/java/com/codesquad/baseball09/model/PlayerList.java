package com.codesquad.baseball09.model;

import java.util.List;

public class PlayerList {

  private String teamName;
  private List<DetailPlayer> players;

  public PlayerList(String teamName, List<DetailPlayer> players) {
    this.teamName = teamName;
    this.players = players;
  }

  public String getTeamName() {
    return teamName;
  }

  public List<DetailPlayer> getPlayers() {
    return players;
  }
}
