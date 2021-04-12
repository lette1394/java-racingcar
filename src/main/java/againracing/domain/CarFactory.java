package againracing.domain;

import java.util.HashSet;
import java.util.Set;

public class CarFactory {
  private final MovementPolicy movementPolicy;

  public CarFactory(MovementPolicy movementPolicy) {
    this.movementPolicy = movementPolicy;
  }

  public Car create(String name) {
    return new Car(name, movementPolicy);
  }

  public Set<Car> create(Set<String> names) {
    final Set<Car> result = new HashSet<>();
    for (String name : names) {
      result.add(create(name));
    }
    return result;
  }
}
