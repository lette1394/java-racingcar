package car;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Car {
  private final Location location;
  private final MovementPolicy movementPolicy;

  public Car(MovementPolicy movementPolicy) {
    this(Location.ZERO, movementPolicy);
  }

  public Car move() {
    if (movementPolicy.next() == Movement.FORWARD) {
      return new Car(location.increase(), movementPolicy);
    }
    return this;
  }

  public Location location() {
    return location;
  }
}
