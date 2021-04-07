package step1;

import static step1.Contracts.requires;

import lombok.Builder;

public class RacingGame {
  private final StringBuilder sb = new StringBuilder();
  private final int cars;
  private final int tries;
  private final CarFactory carFactory;

  @Builder
  public RacingGame(int cars, int tries, CarFactory carFactory) {
    requires(cars > 0, "cars > 0");
    requires(tries > 0, "tries > 0");
    requires(carFactory != null, "carFactory != null");

    this.cars = cars;
    this.tries = tries;
    this.carFactory = carFactory;
  }

  public void run() {
    Round round = new Round(carFactory.create(cars));
    for (int i = 0; i < tries; i++) {

      round = round.moveAll();
      sb.append(round.print());

      if (i == tries - 1) {
        return;
      }
      sb.append("\n\n");
    }
  }

  public String print() {
    return sb.toString();
  }
}
