import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step1.RacingGame;

public class RacingGameTest {
  @Test
  void test1() {
    final RacingGame racingGame = RacingGame.builder()
      .cars(3)
      .tries(5)
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

    racingGame.run();
    racingGame.print();
    assertThat(racingGame.print()).isEqualTo(expected);
  }
}
