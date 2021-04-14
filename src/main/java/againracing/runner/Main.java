package againracing.runner;

import static againracing.view.Printers.carHistory;
import static againracing.view.Printers.finalWinner;
import static againracing.view.Printers.lineBreak;
import static againracing.view.Printers.sequence;

import againracing.domain.CarFactory;
import againracing.domain.RandomMovementPolicy;
import againracing.view.PrinterFactory;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    final CarFactory carFactory = new CarFactory(RandomMovementPolicy.builder()
      .totalBound(10)
      .forwardBound(4)
      .build());
    final PrinterFactory printerFactory = namesOrder -> sequence(List.of(
      lineBreak(1),
      carHistory(namesOrder),
      lineBreak(2),
      finalWinner(namesOrder)));

    final ConsoleRunner runner = ConsoleRunner.builder()
      .inputStream(System.in)
      .outputStream(System.out)
      .carFactory(carFactory)
      .printerFactory(printerFactory)
      .build();

    runner.run();
  }
}
