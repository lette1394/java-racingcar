package againcalc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
  StringCalculator stringCalculator = new StringCalculator(new Operators(new HashMap<>() {{
    put("+", new AddOperator());
    put("-", new SubtractOperator());
    put("*", new MultiplyOperator());
    put("/", new DivideOperator());
  }}));

  @Test
  void test1() {
    assertThat(calculate("2 + 3 * 4 / 2"), is(10L));
  }

  @Test
  void nullInput() {
    assertThrows(IllegalArgumentException.class, () -> calculate(null));
  }

  @Test
  void emptyInput() {
    assertThrows(IllegalArgumentException.class, () -> calculate(""));
  }

  @Test
  void illegalInput() {
    assertThrows(IllegalArgumentException.class, () -> calculate("2 & 3"));
  }

  private long calculate(String expression) {
    return stringCalculator.calculate(expression);
  }
}