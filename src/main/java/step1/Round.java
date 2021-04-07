package step1;

import static step1.Contracts.requires;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
  private final List<Car> cars;

  public Round(List<Car> cars) {
    requires(cars.size() > 0, "cars.size() > 0");
    this.cars = cars;
  }

  public Round moveAll() {
    return new Round(nextCars());
  }

  public String print() {
    return cars
      .stream()
      .map(car -> {
        final StringBuilder sb = new StringBuilder(256);
        for (int i = 0; i < car.location(); i++) {
          sb.append("-");
        }
        return sb.toString();
      })
      .collect(Collectors.joining("\n"));
  }

  private List<Car> nextCars() {
    return cars.stream().map(Car::move).collect(Collectors.toList());
  }
}
