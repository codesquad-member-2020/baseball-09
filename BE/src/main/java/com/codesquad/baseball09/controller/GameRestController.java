package com.codesquad.baseball09.controller;

import static com.codesquad.baseball09.model.api.ApiResult.OK;

import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.State;
import com.codesquad.baseball09.model.api.ApiResult;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.GameResponse;
import com.codesquad.baseball09.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Game API")
public class GameRestController {

  private final Logger log = LoggerFactory.getLogger(GameRestController.class);

  private final GameService service;

  public GameRestController(GameService service) {
    this.service = service;
  }

  @GetMapping("/main")
  @ApiOperation(value = "메인 페이지")
  public ApiResult<List<Match>> main() {
    return OK(service.getMain());
  }

  @PostMapping("/team")
  @ApiOperation(value = "팀 선택")
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

  @PostMapping("/pitch")
  public ApiResult<State> pitch() {
    return OK(service.pitch());
  }

  @GetMapping("/game/score/{id}")
  public ApiResult<List<DetailScore>> getDetailScores(@PathVariable(value = "id") Long gameId) {
    return OK(service.getDetailScore(gameId));
  }
}
