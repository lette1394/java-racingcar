package againracing.runner;

import againracing.domain.CarFactory;
import againracing.domain.Game;
import againracing.view.IO;
import againracing.view.Printer;
import againracing.view.PrinterFactory;
import java.util.List;
import java.util.Set;
import lombok.Builder;

public class ConsoleRunner {
  private final IO io;
  private final CarFactory carFactory;
  private final PrinterFactory printerFactory;

  @Builder
  public ConsoleRunner(
    IO io,
    CarFactory carFactory,
    PrinterFactory printerFactory) {
    this.io = io;
    this.carFactory = carFactory;
    this.printerFactory = printerFactory;
  }

  public void run() {
    final String[] names = getNames();
    final Game game = Game.builder()
      .cars(carFactory.create(Set.of(names)))
      .tries(getTries())
      .build();

    final Printer printer = printerFactory.create(List.of(names));
    io.println(printer.print(game.run()));
  }

  private int getTries() {
    io.println("시도할 회수는 몇회인가요?");
    final int times = Integer.parseInt(io.nextLine());
    return times;
  }

  private String[] getNames() {
    io.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    final String[] names = io.nextLine().split(",");
    return names;
  }
}
