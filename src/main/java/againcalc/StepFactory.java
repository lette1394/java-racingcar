package againcalc;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StepFactory {
  private final Operators operators;

  public Step parse(String expression) {
    return new Step(expression, operators);
  }
}
