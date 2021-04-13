package againcalc;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Step {
  private final static Pattern pattern = Pattern.compile("(.*) ([+*/\\-]+) (\\d+)");
  private final String expression;
  private final Operators operators;

  private final Matcher matcher;
  private final boolean matches;

  public Step(String expression, Operators operators) {
    this.expression = expression;
    this.operators = operators;

    this.matcher = pattern.matcher(expression);
    this.matches = this.matcher.matches();
  }

  public Optional<Long> single() {
    if (matches) {
      return Optional.empty();
    }
    return Optional.of(Long.parseLong(expression));
  }

  public Optional<Long> right() {
    if (matches) {
      return Optional.of(Long.parseLong(matcher.group(3)));
    }
    return Optional.empty();
  }

  public Optional<Operator> operator() {
    if (matches) {
      return operators.parse(matcher.group(2));
    }
    return Optional.empty();
  }

  public Optional<String> rest() {
    if (matches) {
      return Optional.of(matcher.group(1));
    }
    return Optional.empty();
  }
}
