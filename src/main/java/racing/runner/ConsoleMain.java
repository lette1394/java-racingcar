package racing.runner;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.RandomMovementPolicy;
import racing.view.Printer;
import racing.view.StringPrinter;
import racing.view.StringWinnerPrinter;

public class ConsoleMain {
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
