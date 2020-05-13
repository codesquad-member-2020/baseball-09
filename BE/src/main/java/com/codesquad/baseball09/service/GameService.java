package com.codesquad.baseball09.service;

import static com.codesquad.baseball09.model.Pitch.rollDice;

import com.codesquad.baseball09.model.BattingLog;
import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailPlayer;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.InningStatus;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.Status;
import com.codesquad.baseball09.model.api.request.BattingLogRequest;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.PitchRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import com.codesquad.baseball09.repository.JdbcGameRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

  private final Logger logger = LoggerFactory.getLogger(GameService.class);

  private final JdbcGameRepository repository;

  private static Board board;

  public GameService(JdbcGameRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<Match> getMain() {
    return repository.findAllMatches();
  }

  @Transactional
  public void selectTeam(TeamRequest request) {
    repository.updateTeamStatus(request);
  }

  @Transactional
  public GameResponse start(GameRequest request) {
    return repository.startGame(request);
//    board = new Board(response.getId());
//    getPlayer(response.getId());
//    return response;
  }

  @Transactional(readOnly = true)
  public Board getBoard(Long gameId) {
    board.addScore(getScore(gameId));
    return board;
  }

  @Transactional(readOnly = true)
  public void getPlayer(Long gameId) {
    Match match = repository.findById(gameId);
    List<Player> home = repository.findAllPlayersByTeamId(match.getHomeId());
    List<Player> away = repository.findAllPlayersByTeamId(match.getAwayId());
    board.addPlayers(home, away);
  }

  @Transactional(readOnly = true)
  public List<Score> getScore(Long gameId) {
    return repository.findScoreByGameId(gameId);
  }

  @Transactional(readOnly = true)
  public List<DetailScore> getDetailScore(Long gameId) {
    return repository.findDetailScoreByGameId(gameId);
  }

  @Transactional(readOnly = true)
  public List<DetailPlayer> getDetailPlayer(Long gameId) {
    return repository.findDetailPlayerStatusByGameId(gameId);
  }


  @Transactional(readOnly = true)
  public List<BattingLog> getBattingLogs(BattingLogRequest request) {
    return repository.findLogsByGameIdAndInning(request);
  }

  @Transactional
  public void saveInningStatus(InningStatus status) {
    repository.insertOrUpdateStrikeBallOutHitBoard(status);
  }

  @Transactional
  public Status pitch(PitchRequest request) {
    Status state = rollDice(request.getBattingAverage());
    InningStatus status = repository.findStatusByGameId(request.getGameId());
    status.plus(state);
    saveInningStatus(status);
    repository.insertBattingLog(createBattingLog(request, state));
    return state;
  }

  private BattingLog createBattingLog(PitchRequest request, Status status) {
    return new BattingLog.Builder()
        .gameId(request.getGameId())
        .playerId(request.getPlayerId())
        .inning(request.getInning())
        .status(status.getValue())
        .build();
  }
}
