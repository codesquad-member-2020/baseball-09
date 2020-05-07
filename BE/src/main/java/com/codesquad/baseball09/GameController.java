package com.codesquad.baseball09;

import static com.codesquad.baseball09.model.State.BALL;
import static com.codesquad.baseball09.model.State.OUT;
import static com.codesquad.baseball09.model.State.STRIKE;

import com.codesquad.baseball09.model.BatterLog;
import com.codesquad.baseball09.model.Board;
import com.codesquad.baseball09.model.DetailScore;
import com.codesquad.baseball09.model.Game;
import com.codesquad.baseball09.model.InningScore;
import com.codesquad.baseball09.model.Match;
import com.codesquad.baseball09.model.State;
import com.codesquad.baseball09.model.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  @GetMapping("/main")
  public List<Match> main() {
    return Stream.of(
        new Match("Captin", "Marvel"),
        new Match("Twins", "Tigers"),
        new Match("Rockets", "Doggers"),
        new Match("Lotte", "NC")
    ).collect(Collectors.toList());
  }

  @GetMapping("/game")
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
  public String pitch(@PathVariable(value = "matchId") Long id) {
    return "아직까진 구현이 안되었어요";
  }

  @GetMapping("/detail/score/{matchId}")
  public DetailScore detailScore(@PathVariable(value = "matchId") Long id) {
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

}
