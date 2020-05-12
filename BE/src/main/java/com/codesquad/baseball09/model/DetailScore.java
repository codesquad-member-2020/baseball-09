package com.codesquad.baseball09.model;

import java.util.ArrayList;
import java.util.List;

public class DetailScore {

  private final String home;
  private final String away;
  private final List<Score> scores = new ArrayList<>();

  public DetailScore(String home, String away) {
    this.home = home;
    this.away = away;
  }

  public void addInningScore(Score score) {
    scores.add(score);
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public List<Score> getScores() {
    return scores;
  }
}
