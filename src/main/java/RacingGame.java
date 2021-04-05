import java.util.concurrent.atomic.AtomicInteger;

public class RacingGame {
  final StringBuilder sb = new StringBuilder();

  public void run() {
    boolean[] booleans = new boolean[]{
      true, true, true,
      true, false, true,
      true, true, true,
      true, true, true,
      false, true, true,
    };

    AtomicInteger index = new AtomicInteger();
    CanIGo canIGo = () -> booleans[index.getAndIncrement()];

    final Round round = new Round(canIGo);
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
