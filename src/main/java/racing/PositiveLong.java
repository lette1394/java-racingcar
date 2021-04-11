package racing;

import static racing.Contracts.requiresBut;

import lombok.Value;

@Value
public class PositiveLong {
  long value;

  private PositiveLong(long value) {
    requiresBut(value > 0, "value > 0", value);
    this.value = value;
  }

  public static PositiveLong of(long value) {
    return new PositiveLong(value);
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }
}
