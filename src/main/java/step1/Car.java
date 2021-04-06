package step1;

public class Car {
  private final int location;

  public Car() {
    this(0);
  }

  private Car(int location) {
    this.location = location;
  }

  public Car moveForward() {
    return new Car(location + 1);
  }

  public int currentLocation() {
    return location;
  }
}
