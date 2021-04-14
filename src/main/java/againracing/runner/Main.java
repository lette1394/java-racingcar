package againracing.runner;

import againracing.domain.CarFactory;
import againracing.domain.RandomMovementPolicy;

public class Main {
  public static void main(String[] args) {
    final RandomMovementPolicy policy = RandomMovementPolicy.builder()
      .totalBound(10)
      .forwardBound(4)
      .build();
    final CarFactory carFactory = new CarFactory(policy);


    new ConsoleRunner(System.in, carFactory).run();
  }
}
