package racing.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static racing.domain.Movement.FORWARD;
import static racing.domain.Movement.STAY;
import static racing.runner.GameResultMatchers.locatedAt;
import static racing.runner.GameResultMatchers.winnerIs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.MovementPolicy;
import racing.domain.PredefinedMovementPolicy;

public class GameTest2 {
  GameResult gameResult;

  @Test
  void test1() {
    final MovementPolicy movementPolicy = new PredefinedMovementPolicy(Arrays.asList(
      FORWARD, FORWARD, FORWARD,
      FORWARD, STAY, FORWARD,
      FORWARD, FORWARD, FORWARD,
      FORWARD, FORWARD, FORWARD,
      FORWARD, FORWARD, FORWARD
    ));
    final List<String> names = List.of("pobi", "crong", "honux");
    final CarFactory carFactory = new CarFactory(movementPolicy);
    final Game game = Game.builder()
      .names(names)
      .tries(5)
      .carFactory(carFactory)
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
