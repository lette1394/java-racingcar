package racing.view;

import racing.domain.GameResult;

@FunctionalInterface
public interface Printer {
  String print(GameResult gameResult);
}
