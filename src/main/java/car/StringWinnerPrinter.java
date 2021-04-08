package car;

import java.util.stream.Collectors;

public class StringWinnerPrinter implements Printer {
  @Override
  public String print(GameResult gameResult) {
    final String winners = gameResult.winner()
      .stream()
      .map(Car::name)
      .collect(Collectors.joining(", "));
    return winners + "가 최종 우승했습니다.";
  }
}
