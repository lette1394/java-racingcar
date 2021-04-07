package step1;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
  private final MovementPolicy movementPolicy;

  public CarFactory(MovementPolicy movementPolicy) {
    this.movementPolicy = movementPolicy;
  }

  public Car create() {
    return new Car(movementPolicy);
  }

  public List<Car> create(int size) {
    final List<Car> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(create());
    }
    return result;
  }
}
