package againracing.view;

import againracing.domain.GameResult;

@FunctionalInterface
public interface Printer {
  String print(GameResult gameResult);
}
