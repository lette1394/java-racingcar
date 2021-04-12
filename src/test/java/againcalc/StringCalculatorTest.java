package againcalc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  void test1() {
    assertThat(calculate("2 + 3 * 4 / 2"), is(10L));
  }

  private long calculate(String expression) {
    return stringCalculator.calculate(expression);
  }
}