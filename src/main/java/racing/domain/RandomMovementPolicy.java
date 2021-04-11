package racing.domain;

import static java.lang.String.format;
import static racing.Contracts.requires;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Builder;
import racing.PositiveLong;

public class RandomMovementPolicy implements MovementPolicy {
  private final PositiveLong totalBound;
  private final PositiveLong forwardBound;

  @Builder
  public RandomMovementPolicy(long totalBound, long forwardBound) {
    requires(totalBound > forwardBound,
      format("totalBound > forwardBound, totalBound:[%s], forwardBound:[%s]",
        totalBound, forwardBound));

    this.totalBound = PositiveLong.of(totalBound);
    this.forwardBound = PositiveLong.of(forwardBound);
  }

  @Override
  public Movement next() {
    final long random = ThreadLocalRandom.current().nextLong(totalBound.getValue());
    if (random >= forwardBound.getValue()) {
      return Movement.FORWARD;
    }
    return Movement.STAY;
  }
}
