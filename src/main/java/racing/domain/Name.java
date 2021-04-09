package racing.domain;

import lombok.Value;

@Value
public class Name {
  String value;

  @Override
  public String toString() {
    return value;
  }
}
