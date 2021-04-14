package againcalc;

import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringCalculator {
  private final StepFactory stepFactory;

  public long calculate(String expression) {
    if (expression == null) {
      throw new IllegalArgumentException();
    }

    final Step step = stepFactory.parse(expression);
    final Optional<Long> left = step.left().map(this::calculate);
    final Optional<Long> right = step.right();

    return step.operator().operate(left, right)
      .or(step::single)
      .orElseThrow(() -> new IllegalArgumentException("illegal operator"));
  }
}
