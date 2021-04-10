package racing.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import racing.domain.Car;
import racing.domain.Cars;
import racing.runner.GameResult;

@RequiredArgsConstructor
public class StringWinnerPrinter implements Printer {
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
