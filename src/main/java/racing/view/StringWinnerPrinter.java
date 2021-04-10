package racing.view;

import java.util.stream.Collectors;
import racing.domain.Names;
import racing.runner.GameResult;

public class StringWinnerPrinter implements Printer {
  @Override
  public String print(GameResult gameResult) {
    final Names winnerNames = gameResult.winners().names();
    return winnerNames.collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
  }
}
