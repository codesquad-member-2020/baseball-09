package com.codesquad.baseball09.model;

import java.util.List;
import java.util.Stack;

public class BatterLog {

  private final String playerName;
  private final int batOrder;
  private final Stack<State> logs = new Stack<>();

  public BatterLog(String playerName, int batOrder) {
    this.playerName = playerName;
    this.batOrder = batOrder;
  }

  public void addLogs(State state) {
    logs.add(state);
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getBatOrder() {
    return batOrder;
  }

  public List<State> getLogs() {
    return logs;
  }
}
