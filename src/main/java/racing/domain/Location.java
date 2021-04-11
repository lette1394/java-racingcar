package racing.domain;

import lombok.EqualsAndHashCode;
import racing.PositiveOrZeroLong;

@EqualsAndHashCode
class Location {
  public static Location ZERO = new Location(0L);

  PositiveOrZeroLong value;

  public Location(long value) {
    this.value = PositiveOrZeroLong.of(value);
  }

  public Location increase() {
    return new Location(value.getValue() + 1);
  }

  public long getValue() {
    return value.getValue();
  }

  @Override
  public String toString() {
    return Long.toString(value.getValue());
  }
}
