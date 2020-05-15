package com.codesquad.baseball09.controller;

import static com.codesquad.baseball09.model.api.ApiResult.OK;

import com.codesquad.baseball09.model.BattingLog;
import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailPlayer;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.Status;
import com.codesquad.baseball09.model.api.ApiResult;
import com.codesquad.baseball09.model.api.request.BattingLogRequest;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.PitchRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import com.codesquad.baseball09.service.GameService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {

  private final Logger log = LoggerFactory.getLogger(GameRestController.class);

  private final GameService service;

  public GameRestController(GameService service) {
    this.service = service;
  }

  @GetMapping("/main")
  public ApiResult<List<Match>> main() {
    return OK(service.getMain());
  }

  @PostMapping("/team")
  public ApiResult<Boolean> selectTeam(@RequestBody TeamRequest request) {
    service.selectTeam(request);
    return OK(true);
  }

  @PostMapping("/game")
  public ApiResult<GameResponse> startGame(@RequestBody GameRequest request) {
    return OK(service.start(request));
  }

  @GetMapping("/game/{id}")
  public ApiResult<Board> getGame(@PathVariable(value = "id") Long gameId) {
    return OK(service.getBoard(gameId));
  }

  @PostMapping("/game/pitch")
  public ApiResult<Status> pitch(@RequestBody PitchRequest request) {
    return OK(service.pitch(request));
  }

  @GetMapping("/game/score/{id}")
  public ApiResult<List<DetailScore>> getDetailScores(@PathVariable(value = "id") Long gameId) {
    return OK(service.getDetailScore(gameId));
  }

  @GetMapping("/game/player/{id}")
  public ApiResult<List<DetailPlayer>> getDetailPlayers(@PathVariable(value = "id") Long gameId) {
    return OK(service.getDetailPlayer(gameId));
  }

  @GetMapping("/game/{id}/log/{inning}")
  public ApiResult<List<BattingLog>> getBattingLog(
      @PathVariable(value = "id") Long gameId,
      @PathVariable(value = "inning") int inning
  ) {
    return OK(service.getBattingLogs(BattingLogRequest.of(gameId, inning)));
  }
}
