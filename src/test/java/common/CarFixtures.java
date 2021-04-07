package common;

import step1.Car;
import step1.Movement;
import step1.MovementPolicy;

public class CarFixtures {
  public static MovementPolicy alwaysForward() {
    return () -> Movement.FORWARD;
  }

  public static MovementPolicy alwaysStay() {
    return () -> Movement.STAY;
  }

  public static Car aCarWith(MovementPolicy movementPolicy) {
    return new Car(movementPolicy);
  }
}
