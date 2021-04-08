package step2;

public class Contracts {
  public static void requires(boolean truthy, String message) {
    if (truthy) {
      return;
    }
    throw new ContractsViolationException(message);
  }
}
