package againracing.domain;

import java.util.List;
import againracing.Contracts;

public class PredefinedMovementPolicy implements MovementPolicy {
  private final List<Movement> movements;
  private int index = 0;

  public PredefinedMovementPolicy(List<Movement> movements) {
    this.movements = movements;
  }

  @Override
  public Movement next() {
    Contracts.requires(index < movements.size(), "index < movements.size()");
    return movements.get(index++);
  }
}
