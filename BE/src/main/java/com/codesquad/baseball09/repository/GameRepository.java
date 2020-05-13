package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.BattingLog;
import com.codesquad.baseball09.model.DetailPlayer;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.InningStatus;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.api.request.BattingLogRequest;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import java.util.List;

public interface GameRepository {

  List<Match> findAllMatches();

  void updateTeamStatus(TeamRequest request);

  Match findById(Long id);

  GameResponse startGame(GameRequest request);

  List<DetailScore> findDetailScoreByGameId(Long gameId);

  List<Player> findAllPlayersByTeamId(Long id);

  void insertOrUpdateScore(DetailScore detailScore);

  List<Score> findScoreByGameId(Long id);

  void insertOrUpdateStrikeBallOutHitBoard(InningStatus status);

  InningStatus findStatusByGameId(Long gameId);

  void insertBattingLog(BattingLog log);

  List<BattingLog> findLogsByGameIdAndInning(BattingLogRequest request);

  List<DetailPlayer> findDetailPlayerStatusByGameId(Long gameId);
}
