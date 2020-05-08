package com.codesquad.baseball09.repository;

import com.codesquad.baseball09.model.Match;
import java.util.List;

public interface GameRepository {

  List<Match> findAll();
}
