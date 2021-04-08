package step1;

import static step1.Contracts.requires;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    requires(cars.size() > 0, "cars.size() > 0");
    this.cars = cars;
  }

  public Cars moveAll() {
    return new Cars(nextCars());
  }

  public List<Long> locations() {
    return cars.stream()
      .map(Car::location)
      .collect(Collectors.toList());
  }

  private List<Car> nextCars() {
    return cars.stream().map(Car::move).collect(Collectors.toList());
  }
}
