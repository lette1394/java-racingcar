package againracing.view;

import againracing.domain.GameResult;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SequencePrinter implements Printer {
  private final List<Printer> printers;

  @Override
  public String print(GameResult gameResult) {
    return printers.stream()
      .map(printer -> printer.print(gameResult))
      .collect(Collectors.joining());
  }
}
