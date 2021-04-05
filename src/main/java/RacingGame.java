import java.util.Arrays;

public class RacingGame {
  final StringBuilder sb = new StringBuilder();

  public void run() {
    MovementPolicy policy = new PredefinedMovementPolicy(Arrays.asList(
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.STAY, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.FORWARD, Movement.FORWARD, Movement.FORWARD,
      Movement.STAY, Movement.FORWARD, Movement.FORWARD
    ));

    final Round round = new Round(policy);
    for (int i = 0; i < 5; i++) {
      round.run();
      sb.append(round.print());

      if (i == 4) {
        return;
      }
      sb.append("\n\n");
    }
  }

  public String print() {
    return sb.toString();
  }
}
