public class Round {
  private final CanIGo canIGo;

  public Round(CanIGo canIGo) {
    this.canIGo = canIGo;
  }

  Car car1 = new Car();
  Car car2 = new Car();
  Car car3 = new Car();

  public void run() {
    if (canIGo.test()) {
      car1.go();
    }
    if (canIGo.test()) {
      car2.go();
    }
    if (canIGo.test()) {
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
