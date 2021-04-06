package common;

import java.util.concurrent.ThreadLocalRandom;

public class TestFixtures {
  public static long anyPositiveLong() {
    return ThreadLocalRandom.current().nextLong() % 100;
  }
}
