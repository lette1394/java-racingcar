package againcalc;

import java.util.Optional;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringCalculator {
  private final static Pattern pattern = Pattern.compile("(.*) ([+*/\\-]+) (\\d+)");
  private final Operators operators;

  public long calculate(String expression) {
    if (expression == null) {
      throw new IllegalArgumentException();
    }

    final Step step = new Step(expression);
    final Optional<Long> left = step.rest().map(this::calculate);
    final Optional<Long> right = step.right();
    final Optional<Operator> operator = step.operator().flatMap(operators::parse);

    return operator.flatMap(op -> left.flatMap(l -> right.map(r -> op.compute(l, r))))
      .or(step::single)
      .orElseThrow(() -> new IllegalArgumentException("illegal operator"));
  }
}
