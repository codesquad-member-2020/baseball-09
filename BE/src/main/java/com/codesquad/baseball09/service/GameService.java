package com.codesquad.baseball09.service;

import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.response.TeamSelectedResponse;
import com.codesquad.baseball09.repository.JdbcGameRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

  private final JdbcGameRepository repository;

  public GameService(JdbcGameRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<Match> getMain() {
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  public List<TeamSelectedResponse> getTeamSelected(Long matchId) {
    return repository.findByMatchId(matchId);
  }

  @Transactional
  public void start() {

  }

}
