package racing.domain;

import static racing.Contracts.requires;

public class MaximumLocationPolicy implements MovementPolicy {
  private final long maximum;
  private int current = 0;

  public MaximumLocationPolicy(long maximum) {
    requires(maximum >= 0, "maximumLocation >= 0");
    this.maximum = maximum;
  }

  @Override
  public Movement next() {
    if (current++ < maximum) {
      return Movement.FORWARD;
    }
    return Movement.STAY;
  }
}
