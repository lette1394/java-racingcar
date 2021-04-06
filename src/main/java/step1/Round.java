package step1;

public class Round {
  private final MovementPolicy movementPolicy;

  Car car1;
  Car car2;
  Car car3;

  public Round(MovementPolicy movementPolicy) {
    this.movementPolicy = movementPolicy;
    car1 = new Car(movementPolicy);
    car2 = new Car(movementPolicy);
    car3 = new Car(movementPolicy);
  }

  public void run() {
    if (movementPolicy.next() == Movement.FORWARD) {
      car1 = car1.move();
    }
    if (movementPolicy.next() == Movement.FORWARD) {
      car2 = car2.move();
    }
    if (movementPolicy.next() == Movement.FORWARD) {
      car3 = car3.move();
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
