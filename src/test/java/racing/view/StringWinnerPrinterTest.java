package racing.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static racing.domain.Movement.FORWARD;
import static racing.domain.Movement.STAY;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.PredefinedMovementPolicy;
import racing.domain.GameResult;

class StringWinnerPrinterTest {

  @Test
  void test1() {
    final Printer printer = new StringWinnerPrinter(List.of("car3", "car2", "car1"));
    final List<Cars> history = new ArrayList<>();

    Cars cars = new Cars(Set.of(
      new Car("car1", new PredefinedMovementPolicy(List.of(FORWARD, STAY, STAY))),
      new Car("car2", new PredefinedMovementPolicy(List.of(FORWARD, FORWARD, STAY))),
      new Car("car3", new PredefinedMovementPolicy(List.of(FORWARD, STAY, FORWARD)))));

    for (int i = 0; i < 3; i++) {
      cars = cars.moveAll();
      history.add(cars);
    }

    final String print = printer.print(new GameResult(history));
    final String expected = "car3, car2가 최종 우승했습니다.";
    assertThat(print, is(expected));
  }
}