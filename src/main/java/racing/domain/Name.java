package racing.domain;

import static racing.Contracts.requiresBut;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Name {
  private static final int MAX_NAME_LENGTH = 5;
  private final String value;

  public Name(String value) {
    requiresBut(value.length() <= MAX_NAME_LENGTH, "value.length() <= MAX_NAME_LENGTH", value);
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
