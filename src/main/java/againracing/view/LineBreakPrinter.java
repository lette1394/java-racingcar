package againracing.view;

import againracing.domain.GameResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LineBreakPrinter implements Printer {
  private final int count;

  @Override
  public String print(GameResult gameResult) {
    return "\n".repeat(count);
  }
}
