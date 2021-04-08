package step1;

import static step1.Contracts.requires;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameResult {
  private final List<Cars> results;

  public int rounds() {
    return results.size();
  }

  public List<Location> locationsAt(int round) {
    requires(round >= 0, "round >= 0");
    return results.get(round).locations();
  }

  public String print() {
    return results.stream()
      .map(GameResult::print)
      .collect(Collectors.joining("\n\n"));
  }

  public static String print(Cars cars) {
    return cars.locations().stream()
      .map(location -> {
        final StringBuilder sb = new StringBuilder(256);
        for (int i = 0; i < location.getValue(); i++) {
          sb.append("-");
        }
        return sb.toString();
      })
      .collect(Collectors.joining("\n"));
  }
}
