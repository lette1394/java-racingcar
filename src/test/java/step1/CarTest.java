package step1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
  Car subject;

  @BeforeEach
  void beforeEach() {
    subject = subject(alwaysForward());
  }

  @Test
  void test1() {
    long times = 3L;
    tryMove(times);

    assertThat(subject.currentLocation(), is(times));
  }

  private void tryMove(long times) {
    for (int i = 0; i < times; i++) {
      subject = subject.move();
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