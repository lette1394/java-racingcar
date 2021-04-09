package racing.view;

import java.util.stream.Collectors;
import racing.domain.Cars;
import racing.runner.GameResult;

public class StringPrinter implements Printer {

  @Override
  public String print(GameResult gameResult) {
    return gameResult.carsStream()
      .map(StringPrinter::print)
      .collect(Collectors.joining("\n\n"));
  }

  public static String print(Cars cars) {
    return cars.map(car -> {
        final StringBuilder sb = new StringBuilder(256);
        sb.append(car.name());
        sb.append(" : ");
        for (int i = 0; i < car.location(); i++) {
          sb.append("-");
        }
        return sb.toString();
      })
      .collect(Collectors.joining("\n"));
  }
}
