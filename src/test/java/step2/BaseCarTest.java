package step2;

public class BaseCarTest {
  Car aCar;

  protected void triggerMove(long times) {
    for (int i = 0; i < times; i++) {
      aCar = aCar.move();
    }
  }
}
