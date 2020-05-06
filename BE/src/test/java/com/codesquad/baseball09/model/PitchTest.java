package com.codesquad.baseball09.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PitchTest {

  private static Logger logger = LoggerFactory.getLogger(PitchTest.class);
  Player batter;

  @BeforeEach
  void 배터_생성() {
    batter = new Player(1L, 1L, "추신수", 345);
  }

  @Test
  void 배팅_테스트() {
    logger.debug("rollDice : {}", Pitch.rollDice(batter.getBattingAverage()));
  }
}
