package racing.runner;

import static racing.Contracts.requires;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import racing.domain.CarFactory;
import racing.domain.Cars;
import racing.domain.GameResult;

public class RacingGame {
  private final List<String> names;
  private final int tries;
  private final CarFactory carFactory;

  @Builder
  public RacingGame(List<String> names, int tries, CarFactory carFactory) {
    requires(names.size() > 0, "names.size() > 0");
    requires(tries > 0, "tries > 0");
    requires(carFactory != null, "carFactory != null");

    this.names = names;
    this.tries = tries;
    this.carFactory = carFactory;
  }

  public GameResult run() {
    final List<Cars> history = new ArrayList<>();

    Cars cars = new Cars(carFactory.create(names));
    for (int i = 0; i < tries; i++) {
      cars = cars.moveAll();
      history.add(cars);
    }

    return new GameResult(history);
  }
}
