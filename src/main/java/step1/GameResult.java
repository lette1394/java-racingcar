package step1;

import static step1.Contracts.requires;

import java.util.List;
import java.util.stream.Collectors;
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

  public String print() {
    return results.stream()
      .map(GameResult::print)
      .collect(Collectors.joining("\n\n"));
  }

  public static String print(Locations locations) {
    return locations.stream()
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
