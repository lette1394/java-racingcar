package againracing.runner;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import againracing.domain.Car;
import againracing.domain.CarFactory;
import againracing.domain.Game;
import againracing.domain.GameResult;
import againracing.domain.RandomMovementPolicy;
import againracing.view.Printer;
import againracing.view.StringPrinter;
import againracing.view.StringWinnerPrinter;

public class ConsoleRunner {
  public static void main(String[] args) {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    final Scanner scanner = new Scanner(System.in);
    // TODO: remove duplicate
    final String[] names = scanner.nextLine().split(",");
    System.out.println("시도할 회수는 몇회인가요?");
    final int times = Integer.parseInt(scanner.nextLine());

    final RandomMovementPolicy policy = RandomMovementPolicy.builder()
      .totalBound(10)
      .forwardBound(4)
      .build();
    final CarFactory carFactory = new CarFactory(policy);
    final Set<Car> cars = carFactory.create(Set.of(names));
    final Game game = Game.builder()
      .cars(cars)
      .tries(times)
      .build();

    System.out.println();
    System.out.println("실행 결과");
    final GameResult gameResult = game.run();
    final Printer print1 = new StringPrinter(Arrays.asList(names));
    System.out.println(print1.print(gameResult));

    final Printer print2 = new StringWinnerPrinter(Arrays.asList(names));
    System.out.println(print2.print(gameResult));
  }
}