package com.codesquad.baseball09.model;

public class DetailPlayer {

  private String name;
  private int atBat;
  private int hits;
  private int outs;

  public DetailPlayer(String name, int atBat, int hits, int outs) {
    this.name = name;
    this.atBat = atBat;
    this.hits = hits;
    this.outs = outs;
  }

  public String getName() {
    return name;
  }

  public int getAtBat() {
    return atBat;
  }

  public int getHits() {
    return hits;
  }

  public int getOuts() {
    return outs;
  }
}
