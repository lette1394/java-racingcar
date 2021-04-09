package common;

public class TestFixtures {
  public static long anyPositiveLong() {
    return 5;
  }

  public static String anyNonBlankString() {
    return anyNonBlankString(10);
  }

  public static String anyNonBlankString(int size) {
    return "hello";
  }
}
