package step1;

import static common.TestFixtures.anyPositiveLong;
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
  void alwaysGo() {
    long times = anyPositiveLong();
    tryMove(times);

    assertThat(subject.location(), is(times));
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