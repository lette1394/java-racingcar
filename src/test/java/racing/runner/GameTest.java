package racing.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static racing.domain.Movement.FORWARD;
import static racing.domain.Movement.STAY;
import static racing.runner.GameResultMatchers.winnerIs;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racing.domain.CarFactory;
import racing.domain.MovementPolicy;
import racing.domain.PredefinedMovementPolicy;
import racing.view.Printer;
import racing.view.StringPrinter;
import racing.view.StringWinnerPrinter;

public class GameTest {
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
    final Printer printer = new StringPrinter();
    assertThat(printer.print(gameResult), is(expected));
  }

  @Test
  void test11() {
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

    final GameResult gameResult = game.run();
    assertThat(gameResult, winnerIs("pobi", "honux"));
  }


  @Test
  void test2() {
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

    final String expected = "pobi, honux가 최종 우승했습니다.";

    final GameResult gameResult = game.run();
    final Printer printer = new StringWinnerPrinter();
    assertThat(printer.print(gameResult), is(expected));
  }
}
