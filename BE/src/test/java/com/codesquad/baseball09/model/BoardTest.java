package com.codesquad.baseball09.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardTest {

  private static Logger logger = LoggerFactory.getLogger(BoardTest.class);

  Board board;

  @BeforeEach
  void 전광판_객체_생성() {
    board = new Board("Captain", "Marvel");
  }

  @Test
  void 쓰리_스트라이크_아웃() {
    board.addStrike();
    board.addStrike();
    assertEquals(2, board.getStrike());

    board.addStrike();
    assertEquals(0, board.getStrike());
    assertEquals(1, board.getOut());
  }
}
