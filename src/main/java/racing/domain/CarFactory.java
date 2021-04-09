package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
  private final MovementPolicy movementPolicy;

  public CarFactory(MovementPolicy movementPolicy) {
    this.movementPolicy = movementPolicy;
  }

  public Car create(String name) {
    return new Car(name, movementPolicy);
  }

  public List<Car> create(List<String> names) {
    final List<Car> result = new ArrayList<>();
    for (String name : names) {
      result.add(create(name));
    }
    return result;
  }
}
