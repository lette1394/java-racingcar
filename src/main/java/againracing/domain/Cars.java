package againracing.domain;

import static againracing.Contracts.requires;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import againracing.BaseStream;
import againracing.ContractsViolationException;

@EqualsAndHashCode(callSuper = false)
public class Cars extends BaseStream<Car> implements Iterable<Car> {
  private static final int SOLE_WINNER_SIZE = 1;
  private final Set<Car> cars;

  public Cars(Set<Car> cars) {
    super(cars.stream());
    requires(cars.size() > 0, "cars.size() > 0");
    this.cars = cars;
  }

  public Cars moveAll() {
    return new Cars(nextCars());
  }

  public Cars winners() {
    final long maxScore = cars.stream()
      .map(Car::location)
      .max(Comparator.naturalOrder())
      .orElseThrow(() -> new ContractsViolationException("will be never executed"));

    return new Cars(cars.stream()
      .filter(car -> car.location() == maxScore)
      .collect(Collectors.toUnmodifiableSet()));
  }

  public Optional<Car> soleWinner() {
    final Set<Car> winners = winners().cars;
    if (winners.size() == SOLE_WINNER_SIZE) {
      return Optional.of(winners.iterator().next());
    }
    return Optional.empty();
  }

  public Names names() {
    return new Names(cars.stream()
      .map(Car::name)
      .collect(Collectors.toUnmodifiableSet()));
  }

  private Set<Car> nextCars() {
    return cars.stream()
      .map(Car::move)
      .collect(Collectors.toUnmodifiableSet());
  }

  public Optional<Car> findCarOwnedBy(String name) {
    return cars.stream()
      .filter(car -> car.name().equals(name))
      .findAny();
  }

  @Override
  public String toString() {
    return cars.toString();
  }
}