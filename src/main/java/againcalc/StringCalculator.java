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
    final Optional<Long> left = step.rest().map(this::calculate);
    final Optional<Long> right = step.right();
    final Optional<Operator> operator = step.operator();

    return operator.flatMap(op -> left.flatMap(l -> right.map(r -> op.compute(l, r))))
      .or(step::single)
      .orElseThrow(() -> new IllegalArgumentException("illegal operator"));
  }
}
