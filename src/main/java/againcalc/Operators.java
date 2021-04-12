package againcalc;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Operators {
  private final Map<String, Operator> operators;

  public OptionalOperator parse(String operator) {
    if (operators.containsKey(operator)) {
      return new OptionalOperator(Optional.of(operators.get(operator)));
    }
    return new OptionalOperator(Optional.empty());
  }
}
