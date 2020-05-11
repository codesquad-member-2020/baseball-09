package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.TeamResponse;
import java.util.List;

public interface GameRepository {

  List<Match> findAll();

  List<TeamResponse> findByMatchId(Long matchId);

  void updateTeam(TeamRequest teamRequest);
}
