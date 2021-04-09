package racing.runner;

import static racing.Contracts.requires;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import racing.domain.Car;
import racing.domain.Cars;

public class Game {
  private final int tries;
  private final List<Car> cars;

  @Builder
  public Game(int tries, List<Car> cars) {
    requires(tries > 0, "tries > 0");
    requires(cars != null, "carFactory != null");

    this.tries = tries;
    this.cars = cars;
  }

  public GameResult run() {
    final List<Cars> history = new ArrayList<>();

    Cars cars = new Cars(this.cars);
    for (int i = 0; i < tries; i++) {
      cars = cars.moveAll();
      history.add(cars);
    }

    return new GameResult(history);
  }
}
