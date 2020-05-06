package com.codesquad.baseball09.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModelTest {

  private static Logger logger = LoggerFactory.getLogger(ModelTest.class);
  List<Player> list = new ArrayList<>();

  @BeforeEach
  void 플레이어_생성() {
    Player p1 = new Player(1L, 1L, "이용대", 342);
    Player p2 = new Player(2L, 1L, "추신수", 312);
    Player p3 = new Player(3L, 1L, "류현진", 412);
    list.add(p1);
    list.add(p2);
    list.add(p3);
  }

  @Test
  void 팀_생성_테스트() {
    Team t1 = new Team(1L, "Captin", list);
    assertNotNull(t1);
    logger.debug("T1 : {}", t1);
  }

}
