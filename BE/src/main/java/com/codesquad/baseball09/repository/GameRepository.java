package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import java.util.List;

public interface GameRepository {

  List<Match> findAll();

  void updateTeamStatus(TeamRequest request);

  Board start(GameRequest request);
}
