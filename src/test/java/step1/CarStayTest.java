package step1;

import static common.CarAssertions.didntMoveAtAll;
import static common.CarFixtures.aCarWith;
import static common.CarFixtures.alwaysStay;
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