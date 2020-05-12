package com.codesquad.baseball09.service;

import static com.codesquad.baseball09.model.Pitch.rollDice;

import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.State;
import com.codesquad.baseball09.model.api.request.GameRequest;
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

  private static State state;

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
    GameResponse response = repository.start(request);
    board = new Board(response.getId());
    getPlayer(response.getId());
    return response;
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

  public State pitch() {
    if (!board.isBottom()) {
      state = rollDice(board.getGame().getAway().getBattingAverage());
      if (state.equals(State.OUT) || state.equals(State.HIT)) {
        board.getGame().nextAway();
      }
    } else if (board.isBottom()) {
      state = rollDice(board.getGame().getHome().getBattingAverage());
      if (state.equals(State.OUT) || state.equals(State.HIT)) {
        board.getGame().nextHome();
      }
    }
    checkValue(addSBO(state));
    return state;
  }

  private int addSBO(State state) {
    return board.getSbo().plus(state);
  }

  private void checkValue(int value) {
    if (value == 1) {
      if (!board.isBottom()) {
        board.addAwayScore();
        DetailScore awayScore = new DetailScore(
            board.getGameId(),
            board.getGame().getAway().getTeamId(),
            board.getInning(),
            board.getAwayScore(),
            board.isBottom()
        );
        repository.insertOrUpdateScore(awayScore);
      }
      if (board.isBottom()) {
        board.addHomeScore();
        DetailScore homeScore = new DetailScore(
            board.getGameId(),
            board.getGame().getHome().getTeamId(),
            board.getInning(),
            board.getHomeScore(),
            board.isBottom()
        );
        repository.insertOrUpdateScore(homeScore);
      }
    }
    if (value == -1) {
      board.change();
    }
  }
}
