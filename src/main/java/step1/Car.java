package step1;

import static step1.Contracts.requires;

public class Car {
  private final long location;
  private final MovementPolicy movementPolicy;

  public Car(long location, MovementPolicy movementPolicy) {
    requires(location >= 0, "location >= 0");
    requires(movementPolicy != null, "movementPolicy != null");

    this.location = location;
    this.movementPolicy = movementPolicy;
  }

  public Car(MovementPolicy movementPolicy) {
    this(0L, movementPolicy);
  }

  public Car() {
    this(() -> Movement.FORWARD);
  }

  public Car move() {
    return new Car(location + 1, movementPolicy);
  }

  public long currentLocation() {
    return location;
  }
}
