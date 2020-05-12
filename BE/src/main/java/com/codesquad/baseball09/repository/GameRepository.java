package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import java.util.List;

public interface GameRepository {

  List<Match> findAllMatches();

  void updateTeamStatus(TeamRequest request);

  GameResponse start(GameRequest request);

  List<DetailScore> findDetailScoreByGameId(Long gameId);

  Match findById(Long id);

  List<Player> findAllPlayersByTeamId(Long id);

  void insertOrUpdateScore(DetailScore detailScore);

  List<Score> findScoreByGameId(Long id);
}
