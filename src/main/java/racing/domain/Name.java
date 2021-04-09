package racing.domain;

import lombok.Value;

@Value
class Name {
  String value;

  @Override
  public String toString() {
    return value;
  }
}
