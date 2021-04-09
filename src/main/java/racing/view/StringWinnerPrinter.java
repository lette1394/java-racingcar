package racing.view;

import java.util.stream.Collectors;
import racing.domain.Car;
import racing.runner.GameResult;

public class StringWinnerPrinter implements Printer {
  @Override
  public String print(GameResult gameResult) {
    final String winners = gameResult.winner()
      .map(Car::name)
      .collect(Collectors.joining(", "));
    return winners + "가 최종 우승했습니다.";
  }
}
