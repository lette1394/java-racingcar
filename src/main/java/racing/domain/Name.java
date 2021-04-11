package racing.domain;

import static racing.Contracts.requiresBut;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Name {
  private static final int MIN_NAME_LENGTH = 1;
  private static final int MAX_NAME_LENGTH = 5;

  private final String value;

  private Name(String value) {
    requiresBut(value.length() >= MIN_NAME_LENGTH, "value.length() <= MIN_NAME_LENGTH", value);
    requiresBut(value.length() <= MAX_NAME_LENGTH, "value.length() <= MAX_NAME_LENGTH", value);
    this.value = value;
  }

  public static Name of(String value) {
    return new Name(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
