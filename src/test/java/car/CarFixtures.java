package car;

import static common.TestFixtures.anyNonBlankString;

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
