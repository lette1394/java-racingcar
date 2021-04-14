package againcalc;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class OptionalOperator {
  @Delegate
  private final Optional<Operator> holder;

  public Optional<Long> operate(Optional<Long> left, Optional<Long> right) {
    return flatMap(op -> left.flatMap(l -> right.map(r -> op.compute(l, r))));
  }
}
