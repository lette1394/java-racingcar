package racing;

import static racing.Contracts.requires;

import lombok.Value;

@Value
public class PositiveOrZeroLong {
  public static final PositiveOrZeroLong ZERO = new PositiveOrZeroLong(0L);

  long value;

  private PositiveOrZeroLong(long value) {
    requires(value >= 0, "value >= 0");
    this.value = value;
  }

  public static PositiveOrZeroLong of(long value) {
    return new PositiveOrZeroLong(value);
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }
}
