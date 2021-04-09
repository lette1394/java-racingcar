import static org.assertj.core.api.Assertions.assertThat;

import racing.CarFactory;
import racing.GameResult;
import racing.Movement;
import racing.MovementPolicy;
import racing.Names;
import racing.PredefinedMovementPolicy;
import racing.Printer;
import racing.RacingGame;
import racing.StringPrinter;
import racing.StringWinnerPrinter;
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
    final Names names = Names.names(new String[]{"pobi", "crong", "honux"});
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
    final Names names = Names.names(new String[]{"pobi", "crong", "honux"});
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
