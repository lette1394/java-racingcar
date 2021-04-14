package againracing.runner;

import againracing.domain.CarFactory;
import againracing.domain.RandomMovementPolicy;
import againracing.view.PrinterFactory;
import againracing.view.SequencePrinter;
import againracing.view.StringPrinter;
import againracing.view.StringWinnerPrinter;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    final RandomMovementPolicy policy = RandomMovementPolicy.builder()
      .totalBound(10)
      .forwardBound(4)
      .build();
    final CarFactory carFactory = new CarFactory(policy);

    final PrinterFactory printerFactory = nameOrder -> new SequencePrinter(List.of(
      __ -> "\n",
      new StringPrinter(nameOrder),
      __ -> "\n\n",
      new StringWinnerPrinter(nameOrder)));

    final ConsoleRunner runner = ConsoleRunner.builder()
      .inputStream(System.in)
      .carFactory(carFactory)
      .printerFactory(printerFactory)
      .build();

    runner.run();
  }
}
