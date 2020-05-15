package com.codesquad.baseball09.model;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pitch {

  private static final Logger logger = LoggerFactory.getLogger(Pitch.class);

  public static Status rollDice(int battingAverage) {

    double hitProbability = (double) battingAverage / 1000;
    double strikeBallProbability = (1 - hitProbability) / 2 - 0.05;
    double outProbability = 0.100;

    Status status = null;
    boolean isGet = false;
    Random random = new Random();

    while (!isGet) {

      // 25% 확률 1~4
      int number = random.nextInt(4) + 1;
      double dice = Double.parseDouble(String.format("%.3f", random.nextDouble()));

      switch (number) {

        case 1:
          if (dice <= strikeBallProbability) {
            status = Status.STRIKE;
            isGet = true;
          }
          break;

        case 2:
          if (dice <= strikeBallProbability) {
            status = Status.BALL;
            isGet = true;
          }
          break;

        case 3:
          if (dice <= outProbability) {
            status = Status.OUT;
            isGet = true;
          }
          break;

        case 4:
          if (dice <= hitProbability) {
            status = Status.HIT;
            isGet = true;
          }
          break;
      }
    }
    return status;
  }
}
