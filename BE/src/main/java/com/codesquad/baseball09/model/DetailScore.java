package com.codesquad.baseball09.model;

import java.util.ArrayList;
import java.util.List;

public class DetailScore {

  private String home;
  private String away;
  private List<InningScore> inningScores = new ArrayList<>();

  public DetailScore(String home, String away) {
    this.home = home;
    this.away = away;
  }

  public void addInningScore(InningScore score) {
    inningScores.add(score);
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public List<InningScore> getInningScores() {
    return inningScores;
  }
}
