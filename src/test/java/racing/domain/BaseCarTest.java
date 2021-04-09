package racing.domain;

public class BaseCarTest {
  Car aCar;

  protected void triggerMove(long times) {
    for (int i = 0; i < times; i++) {
      aCar = aCar.move();
    }
  }
}
