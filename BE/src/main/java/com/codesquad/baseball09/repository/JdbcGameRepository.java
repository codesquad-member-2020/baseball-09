package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.error.AlreadySelectedException;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Player;
import com.codesquad.baseball09.model.Score;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import com.codesquad.baseball09.model.api.response.TeamResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGameRepository implements GameRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcGameRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Match> findAll() {
    return jdbcTemplate.query(
        "SELECT m.id, h.name as home, h.id as home_id, a.name as away, a.id as away_id, m.is_started "
            + "FROM `match` m "
            + "LEFT JOIN `team` h ON m.home_team_id = h.id "
            + "LEFT JOIN `team` a ON m.away_team_id = a.id"
        , (rs, rowNum) -> new Match(
            rs.getLong("id"),
            rs.getLong("home_id"),
            rs.getLong("away_id"),
            rs.getString("home"),
            rs.getString("away"),
            rs.getBoolean("is_started")
        ));
  }

  @Override
  public void updateTeamStatus(TeamRequest request) {
    TeamResponse response = jdbcTemplate.queryForObject(
        "SELECT t.id, t.name, t.is_selected, t.match_id "
            + "FROM `team` t "
            + "WHERE t.id=?",
        new Object[]{request.getId()}, (rs, rowNum) -> new TeamResponse(
            rs.getLong("id"),
            rs.getLong("match_id"),
            rs.getString("name"),
            rs.getBoolean("is_selected")
        ));

    if (response.isSelected().equals(request.getIsSelected())) {
      throw new AlreadySelectedException(response.getName());
    }

    jdbcTemplate.update("UPDATE `team` SET is_selected=? WHERE id=?",
        request.getIsSelected(),
        request.getId()
    );
  }

  @Override
  public GameResponse start(GameRequest request) {
    jdbcTemplate.update("UPDATE `match` SET is_started=? WHERE id=?",
        request.getIsStarted(),
        request.getId()
    );

//    jdbcTemplate.update("INSERT INTO `game` (id, match_id) VALUES (null,?)"
//        , request.getId());

    return jdbcTemplate.queryForObject(
        "SELECT g.id, g.match_id "
            + "FROM `game` g "
            + "WHERE g.match_id=?",
        new Object[]{request.getId()}, (rs, rowNum) -> new GameResponse(
            rs.getLong("id"),
            rs.getLong("match_id")
        )
    );
  }

  @Override
  public List<Score> getScoreByGameId(Long gameId) {
    return jdbcTemplate.query(
        "SELECT s.id, s.game_id, s.team_id, s.inning, s.score, s.is_bottom "
            + "FROM `score_board` s "
            + "WHERE s.game_id=?",
        new Object[]{gameId}, (rs, rowNum) -> new Score(
            rs.getLong("id"),
            rs.getLong("game_id"),
            rs.getLong("team_id"),
            rs.getInt("inning"),
            rs.getInt("score"),
            rs.getBoolean("is_bottom")
        )
    );
  }

  @Override
  public Match findById(Long id) {
    return jdbcTemplate.queryForObject(
        "SELECT m.id, m.home_team_id as home_id, m.away_team_id as away_id "
            + "FROM `match` m "
            + "WHERE m.id=?", new Object[]{id}, (rs, rowNum) -> new Match(
            rs.getLong("id"),
            rs.getLong("home_id"),
            rs.getLong("away_id")
        ));
  }

  @Override
  public List<Player> findAllByTeamId(Long id) {
    return jdbcTemplate.query(
        "SELECT p.id, p.team_id, p.name, p.batting_average, p.is_pitcher "
            + "FROM `player` p "
            + "WHERE p.team_id=?",
        new Object[]{id}, (rs, rowNum) -> new Player(
            rs.getLong("id"),
            rs.getLong("team_id"),
            rs.getString("name"),
            rs.getInt("batting_average"),
            rs.getBoolean("is_pitcher")
        ));
  }

  @Override
  public void insertTeamScore(Score score) {
    jdbcTemplate
        .update(
            "INSERT INTO `score_board` (`game_id`, `team_id`, `inning`, `score`, `is_bottom`) VALUES (?, ?, ?, ?, ?) ",
            score.getGameId(),
            score.getTeamId(),
            score.getInning(),
            score.getScore(),
            score.getBottom()
        );

  }
}
