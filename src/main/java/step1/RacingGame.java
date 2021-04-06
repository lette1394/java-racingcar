package step1;

import static step1.Contracts.requires;

import lombok.Builder;

public class RacingGame {
  private final StringBuilder sb = new StringBuilder();
  private final int cars;
  private final int tries;
  private final MovementPolicy movementPolicy;

  @Builder
  public RacingGame(int cars, int tries, MovementPolicy movementPolicy) {
    requires(cars > 0, "cars > 0");
    requires(tries > 0, "tries > 0");
    requires(movementPolicy != null, "movementPolicy != null");

    this.cars = cars;
    this.tries = tries;
    this.movementPolicy = movementPolicy;
  }

  public void run() {
    final Round round = new Round(movementPolicy);
    for (int i = 0; i < tries; i++) {

      round.run();
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