package step2;

import java.util.stream.Collectors;

public class StringPrinter implements Printer {

  @Override
  public String print(GameResult gameResult) {
    return gameResult.locationsStream()
      .map(StringPrinter::print)
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
