package step1;

import static step1.Contracts.requires;

import lombok.Value;

@Value
public class PositiveOrZeroLong {
  long value;

  public PositiveOrZeroLong(long value) {
    requires(value >= 0, "value >= 0");
    this.value = value;
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }
}
