package step1;

import static common.CarAssertions.movedExactly;
import static common.TestFixtures.anyPositiveLong;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
  Car aCar;

  @BeforeEach
  void beforeEach() {
    aCar = subject(alwaysForward());
  }

  @Test
  void alwaysGo() {
    long times = anyPositiveLong();
    move(times);

    assertThat(aCar, movedExactly(times));
  }

  private void move(long times) {
    for (int i = 0; i < times; i++) {
      aCar = aCar.move();
    }
  }

  private Car subject(MovementPolicy movementPolicy) {
    return new Car(movementPolicy);
  }

  private MovementPolicy alwaysForward() {
    return () -> Movement.FORWARD;
  }

  private MovementPolicy alwaysStay() {
    return () -> Movement.STAY;
  }
}