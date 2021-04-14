package againracing.domain;

import static againracing.domain.CarMatchers.movedExactly;
import static againracing.domain.CarFixtures.aCarWith;
import static againracing.domain.CarFixtures.alwaysForward;
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