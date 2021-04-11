package racing.domain;

import static java.lang.String.format;
import static racing.Contracts.requires;
import static racing.Contracts.requiresBut;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Builder;

public class RandomMovementPolicy implements MovementPolicy {
  private final long totalBound;
  private final long forwardBound;

  @Builder
  public RandomMovementPolicy(long totalBound, long forwardBound) {
    requiresBut(totalBound > 0, "totalBound > 0", totalBound);
    requiresBut(forwardBound > 0, "forwardBound > 0", forwardBound);
    requires(totalBound > forwardBound,
      format("totalBound > forwardBound, totalBound:[%s], forwardBound:[%s]",
        totalBound, forwardBound));

    this.totalBound = totalBound;
    this.forwardBound = forwardBound;
  }

  @Override
  public Movement next() {
    final long value = ThreadLocalRandom.current().nextLong(totalBound);
    if (value >= forwardBound) {
      return Movement.FORWARD;
    }
    return Movement.STAY;
  }
}
