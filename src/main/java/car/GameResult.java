package car;

import static car.Contracts.requires;

import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameResult {
  private final List<Cars> results;

  public int rounds() {
    return results.size();
  }

  public Locations locationsAt(int round) {
    requires(round >= 0, "round >= 0");
    return results.get(round).locations();
  }

  public Stream<Locations> locationsStream() {
    return results.stream().map(Cars::locations);
  }

  public Stream<Cars> carsStream() {
    return results.stream();
  }
}
