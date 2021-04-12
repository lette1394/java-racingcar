package againcalc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  void test1() {
    assertThat(calculate("2 + 3 * 4 / 2"), is(10L));
  }

  @Test
  void nullInput() {
    assertThrows(IllegalArgumentException.class, () -> calculate(null));
  }

  private long calculate(String expression) {
    return stringCalculator.calculate(expression);
  }
}