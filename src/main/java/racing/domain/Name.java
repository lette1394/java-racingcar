package racing.domain;

import static racing.Contracts.requiresBut;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Name {
  private final String value;

  public Name(String value) {
    requiresBut(value.length() <= 5, "value.length() <= 5", value);
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
