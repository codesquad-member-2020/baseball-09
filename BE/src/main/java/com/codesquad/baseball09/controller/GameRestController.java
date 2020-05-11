package com.codesquad.baseball09.controller;

import static com.codesquad.baseball09.model.State.BALL;
import static com.codesquad.baseball09.model.State.OUT;
import static com.codesquad.baseball09.model.State.STRIKE;
import static com.codesquad.baseball09.model.api.ApiResult.OK;

import com.codesquad.baseball09.model.BatterLog;
import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailPlayer;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Game;
import com.codesquad.baseball09.model.InningScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.PlayerList;
import com.codesquad.baseball09.model.State;
import com.codesquad.baseball09.model.Team;
import com.codesquad.baseball09.model.api.ApiResult;
import com.codesquad.baseball09.model.api.request.GameRequest;
import com.codesquad.baseball09.model.api.request.TeamRequest;
import com.codesquad.baseball09.model.api.response.TeamResponse;
import com.codesquad.baseball09.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

  @GetMapping("/match/{id}")
  @ApiOperation(value = "팀 선택 화면")
  public ApiResult<List<TeamResponse>> main(@PathVariable(value = "id") Long matchId) {
    return OK(service.getTeam(matchId));
  }

  @PostMapping("/team")
  @ApiOperation(value = "팀 선택")
  public ApiResult<Boolean> selectTeam(@RequestBody TeamRequest request) {
    service.selectTeam(request);
    return OK(true);
  }


  @PostMapping("/game")
  public void start(@RequestBody GameRequest request) {
    log.debug("request : {}", request);

  }

  @GetMapping("/game")
  @ApiOperation(value = "게임 진행 페이지")
  public Board getBoard() {
    BatterLog l1 = new BatterLog(
        "추신수",
        5
    );
    l1.addLogs(BALL);
    l1.addLogs(STRIKE);
    l1.addLogs(STRIKE);
    l1.addLogs(STRIKE);
    l1.addLogs(OUT);

    BatterLog l2 = new BatterLog(
        "이용대",
        6
    );
    l2.addLogs(STRIKE);
    l2.addLogs(BALL);
    l2.addLogs(BALL);
    l2.addLogs(State.HIT);

    BatterLog l3 = new BatterLog(
        "류현진",
        7
    );
    l3.addLogs(STRIKE);
    l3.addLogs(BALL);
    l3.addLogs(BALL);
    l3.addLogs(BALL);
    l3.addLogs(STRIKE);

    Board board = new Board(
        new Team(1L, "Captin", 1),
        new Team(2L, "Marvel", 5),
        2,
        false,
        2,
        3,
        2,
        new Game("최동원", "류현진")
    );
    board.addBatterLog(l1);
    board.addBatterLog(l2);
    board.addBatterLog(l3);

    return board;
  }

  @PostMapping("/pitch/{matchId}")
  @ApiOperation(value = "Pitch 버튼 클릭시")
  public String pitch(@PathVariable(value = "matchId") Long id) {
    return "아직까진 구현이 안되었어요";
  }

  @GetMapping("/detail/score/{matchId}")
  @ApiOperation(value = "상세 점수 팝업")
  public DetailScore detailScore(
      @PathVariable(value = "matchId") Long id) {
    DetailScore detailScore = new DetailScore(
        "Captin",
        "Marvel"
    );
    InningScore i1 = new InningScore(
        1,
        1,
        1
    );
    InningScore i2 = new InningScore(
        2,
        0,
        2
    );
    InningScore i3 = new InningScore(
        3,
        0,
        2
    );

    InningScore i4 = new InningScore(
        4,
        0,
        0
    );
    detailScore.addInningScore(i1);
    detailScore.addInningScore(i2);
    detailScore.addInningScore(i3);
    detailScore.addInningScore(i4);
    return detailScore;
  }

  @GetMapping("/detail/player/{matchId}")
  @ApiOperation(value = "상세 선수 명단 팝업")
  public List<PlayerList> detailPlayerList(
      @PathVariable(value = "matchId") Long id) {
    List<DetailPlayer> d1 = Stream.of(
        new DetailPlayer("김광진", 1, 1, 0),
        new DetailPlayer("이동규", 1, 0, 1),
        new DetailPlayer("김진수", 1, 0, 1),
        new DetailPlayer("박영권", 1, 1, 0),
        new DetailPlayer("추신수", 1, 1, 0),
        new DetailPlayer("이용대", 1, 0, 1),
        new DetailPlayer("류현진", 1, 0, 1),
        new DetailPlayer("최동수", 1, 0, 1),
        new DetailPlayer("한양범", 1, 1, 0))
        .collect(Collectors.toList());

    return Stream.of(
        new PlayerList("Captin", d1),
        new PlayerList("Marvel", d1))
        .collect(Collectors.toList());
  }
}
