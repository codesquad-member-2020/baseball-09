package com.codesquad.baseball09.model.api.response;

public class TeamResponse {

  private Long id;
  private Long matchId;
  private String name;
  private Boolean isSelected;

  public TeamResponse(Long id, Long matchId, String name, Boolean isSelected) {
    this.id = id;
    this.matchId = matchId;
    this.name = name;
    this.isSelected = isSelected;
  }

  public Long getId() {
    return id;
  }

  public Long getMatchId() {
    return matchId;
  }

  public String getName() {
    return name;
  }

  public Boolean isSelected() {
    return isSelected;
  }
}
