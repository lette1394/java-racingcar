import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import step2.CarFactory;
import step2.GameResult;
import step2.Movement;
import step2.MovementPolicy;
import step2.PredefinedMovementPolicy;
import step2.Printer;
import step2.RacingGame;
import step2.StringPrinter;

public class RacingGameTest {
  @Test
  void test1() {
    final MovementPolicy movementPolicy = new PredefinedMovementPolicy(Arrays.asList(
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.STAY, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.STAY, Movement.FORWARD, Movement.FORWARD
    ));

    final CarFactory carFactory = new CarFactory(movementPolicy);
    final RacingGame racingGame = RacingGame.builder()
      .cars(3)
      .tries(5)
      .carFactory(carFactory)
      .build();

    final String expected = ""
      + "-\n"
      + "-\n"
      + "-\n"
      + "\n"
      + "--\n"
      + "-\n"
      + "--\n"
      + "\n"
      + "---\n"
      + "--\n"
      + "---\n"
      + "\n"
      + "----\n"
      + "---\n"
      + "----\n"
      + "\n"
      + "----\n"
      + "----\n"
      + "-----";

    final GameResult gameResult = racingGame.run();
    final Printer printer = new StringPrinter();
    assertThat(printer.print(gameResult)).isEqualTo(expected);
  }
}
