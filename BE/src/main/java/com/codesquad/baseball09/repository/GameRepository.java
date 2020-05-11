package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.response.TeamSelectedResponse;
import java.util.List;

public interface GameRepository {

  List<Match> findAll();

  List<TeamSelectedResponse> findByMatchId(Long matchId);
}
