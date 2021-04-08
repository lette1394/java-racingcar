import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import step1.CarFactory;
import step1.GameResult;
import step1.Movement;
import step1.MovementPolicy;
import step1.PredefinedMovementPolicy;
import step1.RacingGame;

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
    assertThat(gameResult.print()).isEqualTo(expected);
  }
}
