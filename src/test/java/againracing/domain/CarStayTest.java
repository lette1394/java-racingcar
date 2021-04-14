package againracing.domain;

import static againracing.domain.CarMatchers.didntMoveAtAll;
import static againracing.domain.CarFixtures.aCarWith;
import static againracing.domain.CarFixtures.alwaysStay;
import static common.TestFixtures.anyPositiveLong;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarStayTest extends BaseCarTest {
  @BeforeEach
  void beforeEach() {
    aCar = aCarWith(alwaysStay());
  }

  @Test
  void stay() {
    triggerMove(anyPositiveLong());

    assertThat(aCar, didntMoveAtAll());
  }
}