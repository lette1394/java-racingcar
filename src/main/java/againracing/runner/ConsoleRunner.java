package againracing.runner;

import againracing.domain.CarFactory;
import againracing.domain.Game;
import againracing.view.Printer;
import againracing.view.PrinterFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import lombok.Builder;

public class ConsoleRunner {
  private final Scanner scanner;
  private final PrintStream printStream;
  private final CarFactory carFactory;
  private final PrinterFactory printerFactory;

  @Builder
  public ConsoleRunner(
    InputStream inputStream,
    OutputStream outputStream,
    CarFactory carFactory,
    PrinterFactory printerFactory) {
    this.scanner = new Scanner(inputStream);
    this.printStream = new PrintStream(outputStream);
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
    printStream.println(printer.print(game.run()));
  }

  private int getTries() {
    printStream.println("시도할 회수는 몇회인가요?");
    final int times = Integer.parseInt(scanner.nextLine());
    return times;
  }

  private String[] getNames() {
    printStream.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    final String[] names = scanner.nextLine().split(",");
    return names;
  }
}
