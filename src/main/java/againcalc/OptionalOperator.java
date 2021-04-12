package againcalc;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class OptionalOperator {
  @Delegate
  private final Optional<Operator> holder;

  public Optional<Long> compute(long left, long right) {
    return holder.map(operator -> operator.compute(left, right));
  }
}
