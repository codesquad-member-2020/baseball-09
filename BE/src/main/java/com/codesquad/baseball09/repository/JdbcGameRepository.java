package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.response.TeamSelectedResponse;
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
        "SELECT m.id, h.name as home, a.name as away, m.is_started "
            + "FROM `match` m "
            + "LEFT JOIN TEAM h ON m.home_team_id = h.id "
            + "LEFT JOIN TEAM a ON m.away_team_id = a.id"
        , (rs, rowNum) -> new Match(
            rs.getLong("id"),
            rs.getString("home"),
            rs.getString("away"),
            rs.getBoolean("is_started")
        ));
  }

  @Override
  public List<TeamSelectedResponse> findByMatchId(Long id) {
    return jdbcTemplate.query(
        "SELECT t.id, t.name, t.is_selected, t.match_id "
            + "FROM `team` t "
            + "WHERE t.match_id =?"
        , new Object[]{id}, (rs, rowNum) -> new TeamSelectedResponse(
            rs.getLong("id"),
            rs.getLong("match_id"),
            rs.getString("name"),
            rs.getBoolean("is_selected")
        ));
  }
}
