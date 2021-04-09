package racing.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static racing.runner.GameResultMatchers.locatedAt;
import static racing.runner.GameResultMatchers.winnerIs;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.MaximumLocationPolicy;

public class GameTest2 {
  GameResult gameResult;

  @Test
  void test1() {
    final List<Car> cars = List.of(
      new Car("pobi", new MaximumLocationPolicy(5)),
      new Car("crong", new MaximumLocationPolicy(4)),
      new Car("honux", new MaximumLocationPolicy(5)));
    final Game game = Game.builder()
      .tries(5)
      .cars(cars)
      .build();
    gameResult = game.run();

    assertThat(gameResult, winnerIs("pobi", "honux"));
    assertThat(aCar("pobi"), locatedAt(5));
    assertThat(aCar("crong"), locatedAt(4));
    assertThat(aCar("honux"), locatedAt(5));
  }

  private Optional<Car> aCar(String name) {
    return gameResult.findCarOwnedBy(name);
  }
}
