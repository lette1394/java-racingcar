package racing;

import static common.TestFixtures.anyNonBlankString;

import racing.domain.Car;
import racing.domain.Movement;
import racing.domain.MovementPolicy;
import racing.domain.Name;

public class CarFixtures {
  public static MovementPolicy alwaysForward() {
    return () -> Movement.FORWARD;
  }

  public static MovementPolicy alwaysStay() {
    return () -> Movement.STAY;
  }

  public static Car aCarWith(MovementPolicy movementPolicy) {
    return new Car(new Name(anyNonBlankString()), movementPolicy);
  }
}
