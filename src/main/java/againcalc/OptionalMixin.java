package againcalc;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public abstract class OptionalMixin<T> {
  @Delegate
  protected final Optional<T> delegate;
}
