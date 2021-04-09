import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import racing.domain.CarFactory;
import racing.domain.GameResult;
import racing.domain.Movement;
import racing.domain.MovementPolicy;
import racing.domain.PredefinedMovementPolicy;
import racing.view.Printer;
import racing.domain.RacingGame;
import racing.view.StringPrinter;
import racing.view.StringWinnerPrinter;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
  @Test
  void test1() {
    final MovementPolicy movementPolicy = new PredefinedMovementPolicy(Arrays.asList(
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.STAY, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD
    ));
    final List<String> names = List.of("pobi", "crong", "honux");
    final CarFactory carFactory = new CarFactory(movementPolicy);
    final RacingGame racingGame = RacingGame.builder()
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

    final GameResult gameResult = racingGame.run();
    final Printer printer = new StringPrinter();
    assertThat(printer.print(gameResult)).isEqualTo(expected);
  }

  @Test
  void test2() {
    final MovementPolicy movementPolicy = new PredefinedMovementPolicy(Arrays.asList(
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.STAY, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD
    ));
    final List<String> names = List.of("pobi", "crong", "honux");
    final CarFactory carFactory = new CarFactory(movementPolicy);
    final RacingGame racingGame = RacingGame.builder()
      .names(names)
      .tries(5)
      .carFactory(carFactory)
      .build();

    final String expected = "pobi, honux가 최종 우승했습니다.";

    final GameResult gameResult = racingGame.run();
    final Printer printer = new StringWinnerPrinter();
    assertThat(printer.print(gameResult)).isEqualTo(expected);
  }
}
