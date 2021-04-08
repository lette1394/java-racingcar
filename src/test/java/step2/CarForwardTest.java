package step2;

import static step2.CarAssertions.movedExactly;
import static step2.CarFixtures.aCarWith;
import static step2.CarFixtures.alwaysForward;
import static common.TestFixtures.anyPositiveLong;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarForwardTest extends BaseCarTest {
  @BeforeEach
  void beforeEach() {
    aCar = aCarWith(alwaysForward());
  }

  @Test
  void alwaysGo() {
    long times = anyPositiveLong();
    triggerMove(times);

    assertThat(aCar, movedExactly(times));
  }
}