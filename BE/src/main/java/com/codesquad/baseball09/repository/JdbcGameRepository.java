package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
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
        "SELECT m.id, h.name as home, a.name as away, m.selected "
            + "FROM `match` m "
            + "LEFT JOIN TEAM h ON m.home_team_id = h.id "
            + "LEFT JOIN TEAM a ON m.away_team_id = a.id"
        , (rs, rowNum) -> new Match(
            rs.getLong("id"),
            rs.getString("home"),
            rs.getString("away"),
            rs.getBoolean("selected")
        ));
  }
}
