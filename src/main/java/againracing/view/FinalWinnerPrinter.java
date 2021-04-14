package againracing.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import againracing.domain.Car;
import againracing.domain.Cars;
import againracing.domain.GameResult;

@RequiredArgsConstructor
public class FinalWinnerPrinter implements Printer {
  private final List<String> namesOrder;

  @Override
  public String print(GameResult gameResult) {
    final Cars winners = gameResult.winners();
    return namesOrder.stream()
      .map(winners::findCarOwnedBy)
      .flatMap(Optional::stream)
      .map(Car::name)
      .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
  }
}