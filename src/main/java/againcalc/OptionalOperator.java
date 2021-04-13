package againcalc;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class OptionalOperator {
  @Delegate
  private final Optional<Operator> holder;

  public Optional<Long> compute(Optional<Long> left, Optional<Long> right) {
    return holder.flatMap(operator -> left.flatMap(l -> right.map(r -> operator.compute(l, r))));
  }
}
