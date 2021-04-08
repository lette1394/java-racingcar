package car;

import static car.Contracts.requires;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    requires(cars.size() > 0, "cars.size() > 0");
    this.cars = cars;
  }

  public Cars moveAll() {
    return new Cars(nextCars());
  }

  public Locations locations() {
    return new Locations(cars.stream()
      .map(Car::location)
      .map(Location::at)
      .collect(Collectors.toList()));
  }

  public Cars winner() {
    final long maxScore = cars.stream()
      .map(Car::location)
      .max(Comparator.naturalOrder())
      .orElse(0L); // FIXME (jaeeun) 2021/04/09 make compiler happy

    return new Cars(cars.stream()
      .filter(car -> car.location() == maxScore)
      .collect(Collectors.toList()));
  }

  public Stream<Car> stream() {
    return cars.stream();
  }

  private List<Car> nextCars() {
    return cars.stream().map(Car::move).collect(Collectors.toList());
  }
}
