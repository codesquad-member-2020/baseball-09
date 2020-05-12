package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import java.util.List;

public interface GameRepository {

  List<Match> findAll();

  void updateTeamStatus(TeamRequest request);

  GameResponse start(GameRequest request);

  List<Score> getScoreByGameId(Long gameId);

  Match findById(Long id);

  List<Player> findAllByTeamId(Long id);

  void insertTeamScore(Score score);
}
