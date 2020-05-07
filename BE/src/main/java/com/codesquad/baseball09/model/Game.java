package com.codesquad.baseball09.model;

public class Game {

  private String pitcher;

  private String batter;

  public Game(String pitcher, String batter) {
    this.pitcher = pitcher;
    this.batter = batter;
  }

  public String getPitcher() {
    return pitcher;
  }

  public String getBatter() {
    return batter;
  }

}
