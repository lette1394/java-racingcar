package againracing.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import againracing.domain.Car;
import againracing.domain.Cars;
import againracing.domain.GameResult;

@RequiredArgsConstructor
public class StringPrinter implements Printer {
  private final List<String> namesOrder;

  @Override
  public String print(GameResult gameResult) {
    return gameResult.rounds()
      .map(this::print)
      .collect(Collectors.joining("\n\n"));
  }

  private String print(Cars cars) {
    return namesOrder.stream()
      .map(cars::findCarOwnedBy)
      .flatMap(Optional::stream)
      .map(this::print)
      .collect(Collectors.joining("\n"));
  }

  private String print(Car car) {
    final StringBuilder sb = new StringBuilder(256);
    sb.append(car.name());
    sb.append(" : ");
    for (int i = 0; i < car.location(); i++) {
      sb.append("-");
    }
    return sb.toString();
  }
}
