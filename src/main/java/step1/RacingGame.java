package step1;

import java.util.Arrays;
import lombok.Builder;

@Builder
public class RacingGame {
  private final StringBuilder sb = new StringBuilder();
  private final int cars;
  private final int tries;

  public void run() {
    MovementPolicy policy = new PredefinedMovementPolicy(Arrays.asList(
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.STAY, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.STAY, Movement.FORWARD, Movement.FORWARD
    ));

    final Round round = new Round(policy);
    for (int i = 0; i < tries; i++) {
      round.run();
      sb.append(round.print());

      if (i == tries - 1) {
        return;
      }
      sb.append("\n\n");
    }
  }

  public String print() {
    return sb.toString();
  }
}
