package step2;

import static step2.CarAssertions.didntMoveAtAll;
import static step2.CarFixtures.aCarWith;
import static step2.CarFixtures.alwaysStay;
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