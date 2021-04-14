package againracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import againracing.PositiveLong;

public class Game {
  private final PositiveLong tries;
  private final Set<Car> cars;

  @Builder
  public Game(long tries, Set<Car> cars) {
    this.tries = PositiveLong.of(tries);
    this.cars = cars;
  }

  public GameResult run() {
    final List<Cars> history = new ArrayList<>();
    final long count = tries.getValue();

    Cars cars = new Cars(this.cars);
    for (int i = 0; i < count; i++) {
      cars = cars.moveAll();
      history.add(cars);
    }

    return new GameResult(history);
  }
}
