package step1;

public class Car {
  private int location;

  public void moveForward() {
    location++;
  }

  public int currentLocation() {
    return location;
  }
}
