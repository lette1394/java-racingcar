package step1;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameResult {
  private final List<Cars> results;

  public String print() {
    return results.stream()
      .map(GameResult::print)
      .collect(Collectors.joining("\n\n"));
  }

  public static String print(Cars cars) {
    return cars.locations().stream()
      .map(location -> {
        final StringBuilder sb = new StringBuilder(256);
        for (int i = 0; i < location; i++) {
          sb.append("-");
        }
        return sb.toString();
      })
      .collect(Collectors.joining("\n"));
  }
}
