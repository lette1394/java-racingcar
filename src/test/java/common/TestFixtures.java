package common;

import static againracing.Contracts.requiresBut;

import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

public class TestFixtures {
  public static long anyPositiveLong() {
    return anyPositiveLong(1, 100);
  }

  public static long anyPositiveLongAtMost(long upperBoundExclusive) {
    return anyPositiveLong(1, upperBoundExclusive);
  }

  public static int anyPositiveIntAtLeast(int lowerBoundInclusive) {
    return anyPositiveInt(lowerBoundInclusive, 100);
  }

  public static int anyPositiveInt(int lowerBoundInclusive, int upperBoundExclusive) {
    return (int) anyPositiveLong(lowerBoundInclusive, upperBoundExclusive);
  }

  public static long anyPositiveLong(long lowerBoundInclusive, long upperBoundExclusive) {
    requiresBut(upperBoundExclusive > 1, "upperBoundExclusive > 1", upperBoundExclusive);
    requiresBut(lowerBoundInclusive > 0, "lowerBoundInclusive > 0", lowerBoundInclusive);
    final long ret = ThreadLocalRandom.current().nextLong(lowerBoundInclusive, upperBoundExclusive);
    if (ret > 0) {
      return ret;
    }
    return -1 * ret;
  }

  public static String anyNonBlankString() {
    return anyNonBlankStringWithLength(10);
  }

  public static String anyNonBlankStringWithLength(int length) {
    return RandomStringUtils.randomAlphanumeric(length);
  }
}
