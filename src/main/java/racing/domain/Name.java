package racing.domain;

import static racing.Contracts.requires;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Name {
  private final String value;

  public Name(String value) {
    requires(value.length() <= 5, "value.length() <= 5");
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
