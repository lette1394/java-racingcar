package racing.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Car {
  private final Name name;
  private final Location location;
  private final MovementPolicy movementPolicy;

  public Car(Name name, MovementPolicy movementPolicy) {
    this(name, Location.ZERO, movementPolicy);
  }

  public String name() {
    return name.toString();
  }

  public Car move() {
    if (movementPolicy.next() == Movement.FORWARD) {
      return new Car(name, location.increase(), movementPolicy);
    }
    return this;
  }

  public long location() {
    return location.getValue();
  }
}
