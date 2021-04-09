package racing.view;

import racing.runner.GameResult;

@FunctionalInterface
public interface Printer {
  String print(GameResult gameResult);
}
