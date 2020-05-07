package com.codesquad.baseball09;

import com.codesquad.baseball09.model.Match;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
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
}
