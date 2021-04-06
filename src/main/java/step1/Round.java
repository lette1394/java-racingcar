package step1;

public class Round {
  private final MovementPolicy movementPolicy;

  public Round(MovementPolicy movementPolicy) {
    this.movementPolicy = movementPolicy;
  }

  Car car1 = new Car();
  Car car2 = new Car();
  Car car3 = new Car();

  public void run() {
    if (movementPolicy.next() == Movement.FORWARD) {
      car1.go();
    }
    if (movementPolicy.next() == Movement.FORWARD) {
      car2.go();
    }
    if (movementPolicy.next() == Movement.FORWARD) {
      car3.go();
    }
  }

  public String print() {
    StringBuilder sb = new StringBuilder(256);
    for (int i = 0; i < car1.location(); i++) {
      sb.append("-");
    }
    sb.append("\n");
    for (int i = 0; i < car2.location(); i++) {
      sb.append("-");
    }
    sb.append("\n");
    for (int i = 0; i < car3.location(); i++) {
      sb.append("-");
    }

    return sb.toString();
  }
}
