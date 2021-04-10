package racing.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static racing.domain.Movement.FORWARD;
import static racing.domain.Movement.STAY;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.PredefinedMovementPolicy;
import racing.view.Printer;
import racing.view.StringPrinter;
import racing.view.StringWinnerPrinter;

public class GameTest {
  final Set<Car> cars = Set.of(
    new Car("pobi", new PredefinedMovementPolicy(List.of(FORWARD, FORWARD, FORWARD, FORWARD, FORWARD))),
    new Car("crong", new PredefinedMovementPolicy(List.of(FORWARD, STAY, FORWARD, FORWARD, FORWARD))),
    new Car("honux", new PredefinedMovementPolicy(List.of(FORWARD, FORWARD, FORWARD, FORWARD, FORWARD))));

  @Test
  void test1() {
    final Game game = Game.builder()
      .tries(5)
      .cars(cars)
      .build();

    final String expected = ""
      + "pobi : -\n"
      + "crong : -\n"
      + "honux : -\n"
      + "\n"
      + "pobi : --\n"
      + "crong : -\n"
      + "honux : --\n"
      + "\n"
      + "pobi : ---\n"
      + "crong : --\n"
      + "honux : ---\n"
      + "\n"
      + "pobi : ----\n"
      + "crong : ---\n"
      + "honux : ----\n"
      + "\n"
      + "pobi : -----\n"
      + "crong : ----\n"
      + "honux : -----";

    final GameResult gameResult = game.run();
    final Printer printer = new StringPrinter(List.of("pobi", "crong", "honux"));
    assertThat(printer.print(gameResult), is(expected));
  }

  @Test
  void test2() {
    final Game game = Game.builder()
      .tries(5)
      .cars(cars)
      .build();

    final String expected = "pobi, honux가 최종 우승했습니다.";

    final GameResult gameResult = game.run();
    final Printer printer = new StringWinnerPrinter(List.of("pobi", "crong", "honux"));
    assertThat(printer.print(gameResult), is(expected));
  }
}
