package com.codesquad.baseball09.model;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pitch {

  private static final Logger logger = LoggerFactory.getLogger(Pitch.class);

  public static State rollDice(int battingAverage) {

//    logger.debug("hitProbability : {} ", battingAverage);
    double hitProbability = (double) battingAverage / 1000;
    double strikeBallProbability = (1 - hitProbability) / 2 - 0.05;
    double outProbability = 0.100;

//    logger.debug("hitProbability : {} ", hitProbability);
//    logger.debug("strikeBallProbability : {} ", strikeBallProbability);

    State state = null;
    boolean isGet = false;
    Random random = new Random();

    while (!isGet) {

      // 25% 확률 1~4
      int number = random.nextInt(4) + 1;
//      logger.debug("number : {} ", number);
      double dice = Double.parseDouble(String.format("%.3f", random.nextDouble()));
//      logger.debug("dice : {} ", dice);

      switch (number) {

        case 1:
          if (dice <= strikeBallProbability) {
            state = State.STRIKE;
            isGet = true;
          }
          break;

        case 2:
          if (dice <= strikeBallProbability) {
            state = State.BALL;
            isGet = true;
          }
          break;

        case 3:
          if (dice <= outProbability) {
            state = State.OUT;
            isGet = true;
          }
          break;

        case 4:
          if (dice <= hitProbability) {
            state = State.HIT;
            isGet = true;
          }
          break;
      }
    }
    return state;
  }
}
