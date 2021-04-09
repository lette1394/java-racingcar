package racing.domain;

import static racing.Contracts.requires;

import lombok.Value;

@Value
public class Location {
  public static Location ZERO = new Location(0L);

  long value;

  private Location(long value) {
    requires(value >= 0, "value >= 0");
    this.value = value;
  }

  public static Location at(long value) {
    return new Location(value);
  }

  public Location increase() {
    return new Location(value + 1);
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }
}
