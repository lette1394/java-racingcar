package racing.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(of = {"name", "location"})
@EqualsAndHashCode(of = "name")
@RequiredArgsConstructor
public class Car {
  private final Name name;
  private final Location location;
  private final MovementPolicy movementPolicy;

  public Car(String name, MovementPolicy movementPolicy) {
    this(new Name(name), Location.ZERO, movementPolicy);
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
