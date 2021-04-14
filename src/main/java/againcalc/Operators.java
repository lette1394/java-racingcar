package againcalc;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Operators {
  private final Map<String, Operator> operators;

  public Optional<Operator> parse(String operator) {
    if (operators.containsKey(operator)) {
      return Optional.of(operators.get(operator));
    }
    return Optional.empty();
  }
}
