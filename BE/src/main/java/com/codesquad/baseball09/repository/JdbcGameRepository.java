package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.error.AlreadySelectedException;
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
  public List<Match> findAllMatches() {
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
  public GameResponse startGame(GameRequest request) {
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
  public List<Player> findAllPlayersByTeamId(Long id) {
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
  public List<Score> findScoreByGameId(Long id) {
    return jdbcTemplate.query(
        "SELECT s.game_id ,s.team_id, t.name, sum(s.score) as score "
            + "FROM `score_board` s "
            + "LEFT JOIN `team` t ON t.id = s.team_id "
            + "WHERE s.game_id=? "
            + "GROUP BY team_id ", new Object[]{id}, (rs, rowNum) -> new Score(
            rs.getLong("game_id"),
            rs.getLong("team_id"),
            rs.getString("name"),
            rs.getInt("score")
        ));
  }

  @Override
  public void insertOrUpdateScore(DetailScore detailScore) {
    jdbcTemplate.update(
        "INSERT INTO `score_board` (game_id, team_id, inning, score, is_bottom) "
            + "VALUES (?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE score=?",
        detailScore.getGameId(),
        detailScore.getTeamId(),
        detailScore.getInning(),
        detailScore.getScore(),
        detailScore.getBottom(),
        detailScore.getScore()
    );
  }

  @Override
  public List<DetailScore> findDetailScoreByGameId(Long gameId) {
    return jdbcTemplate.query(
        "SELECT s.id, s.game_id, s.team_id, s.inning, s.score, s.is_bottom "
            + "FROM `score_board` s "
            + "WHERE s.game_id=?",
        new Object[]{gameId}, (rs, rowNum) -> new DetailScore(
            rs.getLong("id"),
            rs.getLong("game_id"),
            rs.getLong("team_id"),
            rs.getInt("inning"),
            rs.getInt("score"),
            rs.getBoolean("is_bottom")
        )
    );
  }

  /*Strike Ball Out Hit*/

  @Override
  public InningStatus findStatusByGameId(Long gameId) {
    return jdbcTemplate.queryForObject(
        "SELECT b.id, b.game_id, b.inning, b.strike, b.ball, b.out, b.hit "
            + "FROM `strike_ball_out_hit_board` b "
            + "WHERE b.game_Id=?",
        new Object[]{gameId}, (rs, rowNum) -> new InningStatus.Builder()
            .id(rs.getLong("id"))
            .gameId(rs.getLong("game_id"))
            .inning(rs.getInt("inning"))
            .strike(rs.getInt("strike"))
            .ball(rs.getInt("ball"))
            .out(rs.getInt("out"))
            .hit(rs.getInt("hit"))
            .build());
  }

  @Override
  public void insertOrUpdateStrikeBallOutHitBoard(InningStatus status) {
    jdbcTemplate.update(
        "INSERT INTO `strike_ball_out_hit_board` (game_id, inning, strike, ball, out, hit) "
            + "VALUES (?, ?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE inning=? ,strike=?, ball=?, out=?, hit=?",
        status.getGameId(),
        status.getInning(),
        status.getStrike(),
        status.getBall(),
        status.getOut(),
        status.getHit(),
        status.getInning(),
        status.getStrike(),
        status.getBall(),
        status.getOut(),
        status.getHit()
    );
  }

  /*Batting log*/

  @Override
  public List<BattingLog> findLogsByGameIdAndInning(BattingLogRequest request) {
    return jdbcTemplate.query(
        "SELECT b.id, b.game_id, b.player_id, b.inning, b.status "
            + "FROM `batting_log` b "
            + "WHERE b.game_id=? AND b.inning=?",
        new Object[]{request.getGameId(), request.getInning()},
        (rs, rowNum) -> new BattingLog.Builder()
            .id(rs.getLong("id"))
            .gameId(rs.getLong("game_id"))
            .playerId(rs.getLong("player_id"))
            .inning(rs.getInt("inning"))
            .status(rs.getInt("status"))
            .build());
  }

  @Override
  public void insertBattingLog(BattingLog log) {
    jdbcTemplate.update(
        "INSERT INTO `batting_log` (game_id, player_id, inning, status) "
            + "VALUES (?, ?, ?, ?) ",
        log.getGameId(),
        log.getPlayerId(),
        log.getInning(),
        log.getStatusInt());
  }

  @Override
  public List<DetailPlayer> findDetailPlayerStatusByGameId(Long gameId) {
    return jdbcTemplate.query(
        "SELECT b.game_id, p.team_id, b.player_id, p.name, count(b.status) AS atBat, "
            + "(SELECT count(status) FROM BATTING_LOG WHERE status=4 AND b.player_id=player_id ) AS hits, "
            + "(SELECT count(status) FROM BATTING_LOG WHERE status=3 AND b.player_id=player_id ) AS outs "
            + "FROM BATTING_LOG  b "
            + "LEFT JOIN player p ON b.player_id=p.id "
            + "WHERE b.game_id=?"
            + "GROUP BY b.player_id ",
        new Object[]{gameId}, (rs, rowNum) -> DetailPlayer.Builder.of()
            .gameId(rs.getLong("game_id"))
            .teamId(rs.getLong("team_id"))
            .playerId(rs.getLong("player_id"))
            .name(rs.getString("name"))
            .atBat(rs.getInt("atBat"))
            .hits(rs.getInt("hits"))
            .outs(rs.getInt("outs"))
            .build());
  }
}
/*
SELECT b.game_id, b.player_id, p.name, count(b.status) AS atBat,
(SELECT count(status) FROM BATTING_LOG WHERE status=4 AND b.player_id=player_id ) AS hits,
(SELECT count(status) FROM BATTING_LOG WHERE status=3 AND b.player_id=player_id ) AS outs,
(SELECT count(status) FROM BATTING_LOG WHERE status=2 AND b.player_id=player_id ) AS balls,
(SELECT count(status) FROM BATTING_LOG WHERE status=1 AND b.player_id=player_id ) AS strike
FROM BATTING_LOG  b
LEFT JOIN player p ON b.player_id=p.id
GROUP BY b.player_id
*/
