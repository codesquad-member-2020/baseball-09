package com.codesquad.baseball09.model;

import org.springframework.data.annotation.Id;

public class Match {

  @Id
  private final Long id;
  private final String home;
  private final String away;
  private final boolean selected;

  public Match(Long id, String home, String away, boolean selected) {
    this.id = id;
    this.home = home;
    this.away = away;
    this.selected = selected;
  }

  public Long getId() {
    return id;
  }

  public String getHome() {
    return home;
  }

  public String getAway() {
    return away;
  }

  public boolean isSelected() {
    return selected;
  }
}
