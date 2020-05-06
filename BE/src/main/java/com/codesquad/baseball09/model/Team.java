package com.codesquad.baseball09.model;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Team {

  private final Long id;
  private final String name;
  private final List<Player> players;

  public Team(Long id, String name, List<Player> players) {
    this.id = id;
    this.name = name;
    this.players = players;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Player> getPlayers() {
    return players;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("name", name)
        .append("players", players)
        .toString();
  }
}
