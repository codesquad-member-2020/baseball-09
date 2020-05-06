package com.codesquad.baseball09.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Game {

  private String pitcher;

  private String batter;

  //타석
  private int atBat;

  public Game(String pitcher, String batter, int atBat) {
    this.pitcher = pitcher;
    this.batter = batter;
    this.atBat = atBat;
  }

  public String getPitcher() {
    return pitcher;
  }

  public String getBatter() {
    return batter;
  }

  public int getAtBat() {
    return atBat;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("pitcher", pitcher)
        .append("batter", batter)
        .append("atBat", atBat)
        .toString();
  }
}
