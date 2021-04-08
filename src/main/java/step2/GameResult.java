package step2;

import static step2.Contracts.requires;

import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameResult {
  private final List<Locations> results;

  public int rounds() {
    return results.size();
  }

  public Locations locationsAt(int round) {
    requires(round >= 0, "round >= 0");
    return results.get(round);
  }

  public Stream<Locations> locationsStream() {
    return results.stream();
  }
}
