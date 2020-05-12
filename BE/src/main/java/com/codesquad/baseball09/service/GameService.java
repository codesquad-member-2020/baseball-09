package com.codesquad.baseball09.service;

import static com.codesquad.baseball09.model.Pitch.rollDice;

import com.codesquad.baseball09.model.Board;
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
    return repository.findAll();
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
    board.addScoreList(repository.getScoreByGameId(gameId));
    return board;
  }

  @Transactional(readOnly = true)
  public void getPlayer(Long gameId) {
    Match match = repository.findById(gameId);
    List<Player> home = repository.findAllByTeamId(match.getHomeId());
    List<Player> away = repository.findAllByTeamId(match.getAwayId());
    board.addPlayers(home, away);
  }

  public State pitch() {
    if (!board.isBottom()) {
      state = rollDice(board.getGame().getAway().getBattingAverage());
      if (state.equals(State.OUT) || state.equals(State.HIT)) {
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
        board.getGame().nextAway();
      }
    }

    if (board.isBottom()) {
      state = rollDice(board.getGame().getHome().getBattingAverage());
      if (state.equals(State.OUT) || state.equals(State.HIT)) {
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
        board.getGame().nextHome();
      }
    }
    addSBO(state);
    checkThreeStrike();
    checkThreeOut();
    checkFourBall();
    checkFourHit();
    return state;
  }

  private void addSBO(State state) {
    board.getSbo().plus(state);
  }

  private void checkThreeStrike() {
    if (board.getSbo().getStrike() == 3) {
      board.getSbo().plus(State.OUT);
      board.getSbo().setStrike(0);
      board.getSbo().setBall(0);
    }
  }

  private void checkFourHit() {
    if (board.getSbo().getHit() == 4) {
      if (!board.isBottom()) {
        board.addAwayScore();
        board.getSbo().minus(State.HIT);
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
      }
      if (board.isBottom()) {
        board.addHomeScore();
        board.getSbo().minus(State.HIT);
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
      }
    }
  }

  private void checkFourBall() {
    if (board.getSbo().getBall() == 4) {
      if (!board.isBottom()) {
        board.getSbo().plus(State.HIT);
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
      }
      if (board.isBottom()) {
        board.getSbo().plus(State.HIT);
        board.getSbo().setStrike(0);
        board.getSbo().setBall(0);
      }
    }
  }

  private void checkThreeOut() {
    if (board.getSbo().getOut() == 3) {
      getPlayer(board.getGameId());
      Score score = null;

      if (!board.isBottom()) {
        score = new Score(
            board.getGameId(),
            board.getGame().getAway().getTeamId(),
            board.getInning(),
            board.getAwayScore(),
            board.isBottom()
        );

      }

      if (board.isBottom()) {
        score = new Score(
            board.getGameId(),
            board.getGame().getHome().getTeamId(),
            board.getInning(),
            board.getHomeScore(),
            board.isBottom()
        );

      }
      repository.insertTeamScore(score);
      board.change();
    }
  }
}
