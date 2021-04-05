import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {
  @Test
  void test1() {
    final RacingGame racingGame = new RacingGame();

    final String expected = "-\n"
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

    assertThat(racingGame.run()).isEqualTo(expected);
  }
}
