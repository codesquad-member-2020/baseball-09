package com.codesquad.baseball09.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Team {

  @JsonIgnore
  private final Long id;
  private final String name;
  private final int score;

  public Team(Long id, String name, int score) {
    this.id = id;
    this.name = name;
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

}
