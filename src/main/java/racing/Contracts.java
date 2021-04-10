package racing;

import static java.lang.String.format;

public class Contracts {
  public static void requires(boolean truthy, String message) {
    if (truthy) {
      return;
    }
    throw new ContractsViolationException(message);
  }

  public static void requiresBut(boolean truthy, String message, Object but) {
    if (truthy) {
      return;
    }
    throw new ContractsViolationException(format("%s, but: [%s]", message, but));
  }
}
