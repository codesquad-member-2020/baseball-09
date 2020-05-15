package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.BattingLog;
import com.codesquad.baseball09.model.Board;
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

  //team
  void updateTeamStatus(TeamRequest request);

  List<Player> findAllPlayersByTeamId(Long teamId);

  //match
  List<Match> findAllMatches();

  Match findById(Long id);

  //game
  GameResponse startGame(GameRequest request);


  //board
  void createBoard(Long gameId);

  Board findBoardByGameId(Long gamId);

  void insertOrUpdateBoard(Board board);

  //score
  List<Score> findScoreByGameId(Long gameId);

  DetailScore findDetailScoreByGameIdAndTeamIdAndInning(Long gameId, Long teamId, int inning);

  void insertOrUpdateScore(DetailScore detailScore);

  //inning
  InningStatus findStatusByGameId(Long gameId);

  void insertOrUpdateStrikeBallOutHitBoard(InningStatus status);


  //battingLog
  void insertBattingLog(BattingLog log);

  List<BattingLog> findLogsByGameIdAndInning(BattingLogRequest request);

  //detail
  List<DetailScore> findDetailScoreByGameId(Long gameId);

  List<DetailPlayer> findDetailPlayerStatusByGameId(Long gameId);

}
