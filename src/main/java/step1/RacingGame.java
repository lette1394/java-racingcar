package step1;

import static step1.Contracts.requires;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;

public class RacingGame {
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

  public GameResult run() {
    final List<Cars> history = new ArrayList<>();

    Cars cars = new Cars(carFactory.create(this.cars));
    for (int i = 0; i < tries; i++) {
      cars = cars.moveAll();
      history.add(cars);
    }

    return new GameResult(history);
  }
}
