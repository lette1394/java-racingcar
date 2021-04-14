package againracing.runner;

import static againracing.domain.Movement.FORWARD;
import static againracing.domain.Movement.STAY;
import static againracing.view.Printers.carHistory;
import static againracing.view.Printers.finalWinner;
import static againracing.view.Printers.lineBreak;
import static againracing.view.Printers.sequence;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import againracing.domain.Car;
import againracing.domain.CarFactory;
import againracing.domain.PredefinedMovementPolicy;
import againracing.view.IO;
import againracing.view.PrinterFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleRunnerTest {
  User aUser;
  ByteArrayOutputStream rawGameOutput = new ByteArrayOutputStream();
  CarFactory carFactory;
  PrinterFactory printerFactory;

  @BeforeEach
  void beforeEach() {
    // FIXME (jaeeun) 2021/04/15: remove magic strings: pobi, crong, ...
    final Set<Car> predefinedCars = Set.of(
      new Car("pobi", new PredefinedMovementPolicy(List.of(FORWARD, FORWARD, FORWARD, FORWARD, FORWARD))),
      new Car("crong", new PredefinedMovementPolicy(List.of(FORWARD, STAY, FORWARD, FORWARD, FORWARD))),
      new Car("honux", new PredefinedMovementPolicy(List.of(FORWARD, FORWARD, FORWARD, FORWARD, FORWARD))));

    aUser = aUser();
    rawGameOutput = new ByteArrayOutputStream();
    carFactory = __ -> predefinedCars;
    printerFactory = namesOrder -> sequence(List.of(
      lineBreak(1),
      carHistory(namesOrder),
      lineBreak(2),
      finalWinner(namesOrder)));
  }

  @Test
  void simulate() {
    aUser.typeCarNames("pobi,crong,honux");
    aUser.enter();
    aUser.typeTryTimes(5);
    aUser.enter();

    simulateGame();

    final String expected = "" +
      "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
      + "시도할 회수는 몇회인가요?\n"
      + "\n"
      + "pobi : -\n"
      + "crong : -\n"
      + "honux : -\n"
      + "\n"
      + "pobi : --\n"
      + "crong : -\n"
      + "honux : --\n"
      + "\n"
      + "pobi : ---\n"
      + "crong : --\n"
      + "honux : ---\n"
      + "\n"
      + "pobi : ----\n"
      + "crong : ---\n"
      + "honux : ----\n"
      + "\n"
      + "pobi : -----\n"
      + "crong : ----\n"
      + "honux : -----\n"
      + "\n"
      + "pobi, honux가 최종 우승했습니다.";

    assertThat(getConsoleOutput(), is(expected));
  }

  private void simulateGame() {
    ConsoleRunner.builder()
      .io(simulateIo())
      .carFactory(carFactory)
      .printerFactory(printerFactory)
      .build()
      .run();
  }

  private IO simulateIo() {
    return IO.builder()
      .inputStream(getUserInput())
      .outputStream(rawGameOutput)
      .build();
  }

  private ByteArrayInputStream getUserInput() {
    return new ByteArrayInputStream(aUser.toUserInputString().getBytes(StandardCharsets.UTF_8));
  }

  private String getConsoleOutput() {
    return rawGameOutput.toString();
  }

  private User aUser() {
    return new User();
  }
}