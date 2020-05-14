package com.codesquad.baseball09.service;

import static com.codesquad.baseball09.model.Pitch.rollDice;

import com.codesquad.baseball09.model.BattingLog;
import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailPlayer;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Game;
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
    GameResponse response = repository.startGame(request);
    createBoard(response.getId());
    saveInningStatus(new InningStatus.Builder().gameId(response.getId()).inning(1).build());
    Match match = repository.findById(response.getId());

    DetailScore home = DetailScore.Builder.aDetailScore()
        .gameId(response.getId())
        .inning(1)
        .teamId(match.getHomeId()).build();
    repository.insertOrUpdateScore(home);

    DetailScore away = DetailScore.Builder.aDetailScore()
        .gameId(response.getId())
        .inning(1)
        .teamId(match.getAwayId()).build();

    repository.insertOrUpdateScore(away);

    return response;
  }

  @Transactional(readOnly = true)
  public Board getBoard(Long gameId) {
    Board board = repository.findBoardByGameId(gameId);
    Game game = getGame(board);

    InningStatus status = repository.findStatusByGameId(gameId);
    List<Score> scores = getScore(gameId);
    return new Board.Builder(board)
        .game(game)
        .score(scores)
        .status(status)
        .build();
  }

  @Transactional(readOnly = true)
  public Game getGame(Board board) {
    Match match = repository.findById(board.getGameId());
    List<Player> home = repository.findAllPlayersByTeamId(match.getHomeId());
    List<Player> away = repository.findAllPlayersByTeamId(match.getAwayId());
    return Game.of(
        home.get(0).getTeamId(), away.get(0).getTeamId(),
        home, away,
        board.getHomeOrder(), board.getAwayOrder());
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
    int value = status.plus(state);

    if (value == 1) {
      DetailScore score = repository
          .findDetailScoreByGameIdAndTeamIdAndInning(request.getGameId(), request.getTeamId(),
              request.getInning());
      logger.debug("score : {}", score);
      score.addScore();
      repository.insertOrUpdateScore(score);
    }

    if (value == -1) {
      Board board = repository.findBoardByGameId(request.getGameId());
      logger.debug("board : {}", board);
      board.change();
      repository.insertOrUpdateBoard(board);
    }

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

  private void createBoard(Long gameId) {
    repository.createBoard(gameId);
  }

}
