import static org.assertj.core.api.Assertions.assertThat;

import car.CarFactory;
import car.GameResult;
import car.Movement;
import car.MovementPolicy;
import car.Names;
import car.PredefinedMovementPolicy;
import car.Printer;
import car.RacingGame;
import car.StringPrinter;
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
      Movement.STAY, Movement.FORWARD, Movement.FORWARD
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
      + "pobi : ----\n"
      + "crong : ----\n"
      + "honux : -----";

    final GameResult gameResult = racingGame.run();
    final Printer printer = new StringPrinter();
    assertThat(printer.print(gameResult)).isEqualTo(expected);
  }
}
