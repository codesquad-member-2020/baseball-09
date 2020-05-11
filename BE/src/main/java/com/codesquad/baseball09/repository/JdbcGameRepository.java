package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.error.AlreadySelectedException;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.TeamResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGameRepository implements GameRepository {

  private final Logger log = LoggerFactory.getLogger(JdbcGameRepository.class);
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
  public void updateTeam(TeamRequest request) {
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

    if (response.isSelected()) {
      throw new AlreadySelectedException(response.getName());
    }

    jdbcTemplate.update("UPDATE team SET is_selected=? WHERE id=?",
        request.getIsSelected(),
        request.getId()
    );
  }
}
