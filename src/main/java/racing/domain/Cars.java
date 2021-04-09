package racing.domain;

import static racing.Contracts.requires;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racing.BaseStream;

public class Cars extends BaseStream<Car> {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    super(cars.stream());
    requires(cars.size() > 0, "cars.size() > 0");
    this.cars = cars;
  }

  public Cars moveAll() {
    return new Cars(nextCars());
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

  public Optional<Car> soleWinner() {
    final List<Car> winners = winner().cars;
    if (winners.size() == 1) {
      return Optional.of(winners.get(0));
    }
    return Optional.empty();
  }

  public Names names() {
    return new Names(cars.stream()
      .map(Car::name)
      .collect(Collectors.toList()));
  }

  private List<Car> nextCars() {
    return cars.stream().map(Car::move).collect(Collectors.toList());
  }

  public Optional<Car> findCarOwnedBy(String name) {
    return cars.stream()
      .filter(car -> car.name().equals(name))
      .findAny();
  }
}
