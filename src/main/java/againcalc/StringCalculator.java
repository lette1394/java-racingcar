package againcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  private final Pattern pattern = Pattern.compile("(.*) ([+*/\\-]+) (\\d+)");

  public long calculate(String expression) {
    final Matcher matcher = pattern.matcher(expression);
    if (!matcher.matches()) {
      return Long.parseLong(expression);
    }

    final String restExpression = matcher.group(1);
    final long leftOperand = calculate(restExpression);
    final String operator = matcher.group(2);
    final long rightOperand = Long.parseLong(matcher.group(3));

    if (operator.equals("+")) {
      return leftOperand + rightOperand;
    }

    if (operator.equals("-")) {
      return leftOperand - rightOperand;
    }

    if (operator.equals("/")) {
      return leftOperand / rightOperand;
    }

    if (operator.equals("*")) {
      return leftOperand * rightOperand;
    }

    throw new IllegalArgumentException("unsupported operator: " + operator);
  }
}
