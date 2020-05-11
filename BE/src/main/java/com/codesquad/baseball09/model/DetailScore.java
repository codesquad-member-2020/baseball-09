package com.codesquad.baseball09.model;

import java.util.ArrayList;
import java.util.List;

public class DetailScore {

  private String home;
  private String away;
  private List<ScoreBoard> scoreBoards = new ArrayList<>();

  public DetailScore(String home, String away) {
    this.home = home;
    this.away = away;
  }

  public void addInningScore(ScoreBoard score) {
    scoreBoards.add(score);
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public List<ScoreBoard> getScoreBoards() {
    return scoreBoards;
  }
}
